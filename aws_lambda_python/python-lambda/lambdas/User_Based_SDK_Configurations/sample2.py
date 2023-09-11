import boto3
from botocore.config import Config

def lambdaFunc(event, context):
    # Config object is influenced by User Input (any parameter)
    config = Config(region_name=event['region'], # User input influences the region name
            signature_version=event['sig-version'], # User input influences the signature version
            user_agent=event['agent'], # User input influences the user agent
            user_agent_extra=event['agent-extra'], # User input influences the user agent extra
            connect_timout=event['con-timeout'], # User input influences the connection timeout
            read_timeout=event['read-timeout'], # User input influences the read timeout
            parameter_validation=event['par-validation'], # User input influences the parameter validation
            max_pool_connections=event['pool-connections'], # User input influences the max pool connections
            proxies=context.client_context.custom['proxy'], # User input influences the proxies
            proxies_config=context.client_context.custom['proxy-config'], # User input influences the proxies configuration
            s3=context.client_context.custom['s3'], # User input influences the s3 service config
            retries=context.client_context.custom['retries'], # User input influences the number of retries
            client_cert=context.client_context.custom['client-cert'], # User input influences the client certificate
            inject_host_prefix=context.client_context.custom['host-prefix'], # User input influences the host prefix
            use_dualstack_endpoint=context.client_context.custom['dualstack'], # User input influences the use of dual stack
            use_fips_endpoint=context.client_context.custom['fips']) # User input influences the use of fips
    # Config object is used when creating the client or resource
    client = boto3.client('lambda', config=config) # Result for the config parameter
    client = boto3.resource('s3', config=config) # Result for the config parameter
