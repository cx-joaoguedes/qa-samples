import * as AWS from "@aws-sdk/client-kafka";

var kafka = new AWS.Kafka();

var params = {
  ClusterArn: 'STRING_VALUE',
  SecretArnList: [
    'STRING_VALUE',
  ]
};

kafka.listClusters(params, function(err, data) {});

kafka.listScramSecrets(params, function(err, data) {});

kafka.getBootstrapBrokers(params, function(err, data) {});

kafka.describeCluster(params, function(err, data) {});

kafka.describeClusterOperation(params, function(err, data) {});

var paramsToCreate = {
  ClusterName: 'STRING_VALUE'
};

kafka.createCluster(paramsToCreate, function(err, data) {});