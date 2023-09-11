import boto3

resource = boto3.resource('s3')

## 3rd Order Inputs

def s3_resource_bucket_acl():
    bucket_acl = resource.BucketAcl('bucket_name')
    grants = bucket_acl.grants  # Input 1
    owner = bucket_acl.owner  # Input 2

def s3_resource_bucket_cors():
    bucket_cors = resource.BucketCors('bucket_name')
    cors_rules = bucket_cors.cors_rules  # Input 3

def s3_resource_bucket_lifecycle():
    bucket_lifecycle = resource.BucketLifecycle('bucket_name')
    rules = bucket_lifecycle.rules  # Input 4

def s3_resource_bucket_lifecycle_configuration():
    bucket_lifecycle_configuration = resource.BucketLifecycleConfiguration('bucket_name')
    rules = bucket_lifecycle_configuration.rules  # Input 5

def s3_resource_bucket_logging():
    bucket_logging = resource.BucketLogging('bucket_name')
    logging_enabled = bucket_logging.logging_enabled  # Input 6

def s3_resource_bucket_notification():
    bucket_notification = resource.BucketNotification('bucket_name')
    event_bridge_configuration = bucket_notification.event_bridge_configuration  # Input 7
    lambda_function_configurations = bucket_notification.lambda_function_configurations  # Input 8
    queue_configurations = bucket_notification.queue_configurations  # Input 9
    topic_configurations = bucket_notification.topic_configurations  # Input 10

def s3_resource_bucket_website():
    bucket_website = resource.BucketWebsite('bucket_name')
    error_document = bucket_website.error_document  # Input 11
    index_document = bucket_website.index_document  # Input 12
    redirect_all_requests_to = bucket_website.redirect_all_requests_to['HostName']  # Input 13
    routing_rules = bucket_website.routing_rules  # Input 14

def s3_resource_object():
    objectreso = resource.Object('bucket_name','key')
    everything = objectreso.allAttributes  # Input 15

def s3_resource_bucket_tagging():
    bucket_lifecycle = resource.BucketTagging('bucket_name')
    rules = bucket_lifecycle.tag_set  # Input 4
