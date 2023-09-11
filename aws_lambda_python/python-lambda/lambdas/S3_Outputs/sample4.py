import boto3

resource = boto3.resource('s3')

## 2nd Order Outputs

def s3_bucket_acl():
    bucket_acl = resource.BucketAcl('bucket_name')
    bucket_acl.grants = []
    bucket_acl.load()
    #bucket_acl.reload()

def s3_bucket_cors():
    bucket_cors = resource.BucketCors('bucket_name')
    bucket_cors.cors_rules = []
    bucket_cors.load()
    #bucket_cors.reload()

def s3_bucket_lifecycle():
    bucket_lifecycle = resource.BucketLifecycle('bucket_name')
    bucket_lifecycle.rules = []
    bucket_lifecycle.load()
    #bucket_lifecycle.reload()

def s3_bucket_lifecycle_configuration():
    bucket_lifecycle_configuration = resource.BucketLifecycleConfiguration('bucket_name')
    bucket_lifecycle_configuration.rules = []
    bucket_lifecycle_configuration.load()
    #bucket_lifecycle_configuration.reload()

def s3_bucket_logging():
    bucket_logging = resource.BucketLogging('bucket_name')
    bucket_logging.logging_enabled = {}
    bucket_logging.load()
    #bucket_logging.reload()

def s3_bucket_notification():
    bucket_notification = resource.BucketNotification('bucket_name')
    bucket_notification.event_bridge_configuration = {}
    bucket_notification.load()
    #bucket_notification.reload()

def s3_bucket_tagging():
    bucket_tagging = resource.BucketTagging('bucket_name')
    bucket_tagging.tag_set = []
    bucket_tagging.load()
    #bucket_tagging.reload()

def s3_bucket_website():
    bucket_website = resource.BucketWebsite('bucket_name')
    bucket_website.error_document = {}
    bucket_website.load()
    #bucket_website.reload()

def s3_object_acl():
    object_acl = resource.ObjectAcl('bucket_name','object_key')
    object_acl.grants = []
    object_acl.load()
    #object_acl.reload()
