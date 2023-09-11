//const axios = require('axios');
const AWS = require("aws-sdk");
const merge = require('lodash.merge');

const BuildConfigComparer = class {
    
    getLastAllowedEvalCommitHash = async (repo_name, environment, commit_hash) => {

        const dynamo = new AWS.DynamoDB.DocumentClient();
        
        let filterExp
        if(environment && !commit_hash) {
            filterExp = 'environment = :env'
        }
        if(environment && commit_hash) {
            filterExp = 'environment = :env AND commit_hash <> :commit_hash'
        }
        if(!environment && commit_hash) {
            filterExp = 'commit_hash <> :commit_hash'
        }

        const eval_history = await dynamo
            .query({
                TableName: process.env.OPA_HISTORY_TABLE,
                IndexName: "repo_name-allow-index",
                ExpressionAttributeValues: {
                    ":env": environment,
                    ":commit_hash": commit_hash,
                    ":repo_name_pcr_allow": `${repo_name}-true`
                },
                Limit: 10,
                ScanIndexForward: false,  // read most recent entry first
                KeyConditionExpression: "repo_name_pcr_allow = :repo_name_pcr_allow",
                FilterExpression: filterExp,
                ProjectionExpression: "commit_hash"
            }).promise();

            
        if (eval_history?.Items && eval_history.Items.length > 0)
            return eval_history.Items[0].commit_hash;
        else
            return null;
    };

    getBuildConfigFromHash = async (commit_hash) => {
        const dynamo = new AWS.DynamoDB.DocumentClient();

        const build_item = await dynamo
            .get({
                TableName: process.env.BUILD_DATA_TABLE,
                Key: {
                    commit_hash: commit_hash
                },
                ProjectionExpression: "build_config"
            })
            .promise();
    
        return build_item.Item?.build_config;
    };

    getBuildItemFromHash = async (commit_hash) => {
        const dynamo = new AWS.DynamoDB.DocumentClient();

        const build_item = await dynamo
            .get({
                TableName: process.env.BUILD_DATA_TABLE,
                Key: {
                    commit_hash: commit_hash
                }
            })
            .promise();
    
        return build_item.Item;
    };

    getComparisonBuildConfig = async (commit_hash, repo_name, incomingBuildConfig, current_build_config = null) => {
        console.log(commit_hash, repo_name, incomingBuildConfig, current_build_config)

        // params is an object in the form of:
        /***
        {
            "parameters": {
                "$LANE": {
                    "digest": {
                        "sha256": "$PARAMETERS_SHA"
                    }
                }
            }
        }
        */

        current_build_config = 
            current_build_config || 
            await this.getBuildConfigFromHash(commit_hash) ||
                {
                    artifact: {},
                    parameters: {}
                };

        //console.log(current_build_config);

        if (incomingBuildConfig.artifact) {
            current_build_config.artifact = incomingBuildConfig.artifact;
        }

        if (incomingBuildConfig.parameters) {
            for (const env in incomingBuildConfig.parameters) {
                let last_eval_commit_hash = await this.getLastAllowedEvalCommitHash(repo_name, env, commit_hash);
                //console.info(`CH: ${last_eval_commit_hash}`);

                let last_eval_build_config = null;
        
                if (last_eval_commit_hash) {
                    // get the build_config field of the build item record based on the commit hash
                    last_eval_build_config = await this.getBuildConfigFromHash(last_eval_commit_hash);
                }
        
                //console.info(`LBCF: ${last_eval_build_config}`);

                // ensure a proper structure to the config (build_config may be null)
                last_eval_build_config = last_eval_build_config || {
                    parameters: {
                        [env]: { }
                    }
                };
        
                const digestKeys = Object.keys(incomingBuildConfig.parameters[env]?.digest || {})
                const hashingAlgoKey = digestKeys.length > 0 ? digestKeys[0] : 'sha256'

                let current_hash = incomingBuildConfig.parameters[env]?.digest?.[hashingAlgoKey];
                let last_hash = last_eval_build_config.parameters[env]?.digest?.[hashingAlgoKey];

                current_build_config.parameters = merge(current_build_config.parameters, {
                    [env]: {
                        changed: (last_hash !== current_hash),
                        last_eval_commit_hash: last_eval_commit_hash,
                        digest: { [hashingAlgoKey]: current_hash }
                    }
                });

                let debug_obj = {
                    last_eval_commit_hash: last_eval_commit_hash,
                    current_commit_hash: commit_hash,
                    current_hash: current_hash,
                    last_hash: last_hash,
                    build_config: current_build_config,
                    incomingBuildConfig: incomingBuildConfig
                };

                console.debug(JSON.stringify(debug_obj));
            }
        }

        //console.log(JSON.stringify(build_config));
        return current_build_config;
    }
}

module.exports = BuildConfigComparer;
