import boto3

client = boto3.client('s3')

## 2nd Order Outputs

def s3_client_create_bucket():
    response = client.create_bucket(
        Bucket='string'
    )

def s3_client_put_bucket_acl():
    response = client.put_bucket_acl(
        Bucket='string'
    )

def s3_client_put_bucket_analytics_configuration():
    response = client.put_bucket_analytics_configuration(
        Bucket='string'
    )

def s3_client_put_bucket_cors():
    response = client.put_bucket_cors(
        Bucket='string'
    )

def s3_client_put_bucket_intelligent_tiering_configuration():
    response = client.put_bucket_intelligent_tiering_configuration(
        Bucket='string'
    )

def s3_client_put_bucket_inventory_configuration():
    response = client.put_bucket_inventory_configuration(
        Bucket='string'
    )

def s3_client_put_bucket_lifecycle_configuration():
    response = client.put_bucket_lifecycle_configuration(
        Bucket='string'
    )

def s3_client_put_bucket_logging():
    response = client.put_bucket_logging(
        Bucket='string'
    )

def s3_client_put_bucket_metrics_configuration():
    response = client.put_bucket_metrics_configuration(
        Bucket='string'
    )

def s3_client_put_bucket_notification_configuration():
    response = client.put_bucket_notification_configuration(
        Bucket='string'
    )

def s3_client_put_bucket_replication():
    response = client.put_bucket_replication(
        Bucket='string'
    )

def s3_client_put_bucket_tagging():
    response = client.put_bucket_tagging(
        Bucket='string'
    )

def s3_client_put_bucket_website():
    response = client.put_bucket_website(
        Bucket='string'
    )

def s3_client_put_object_acl():
    response = client.put_object_acl(
        Bucket='string'
    )

def s3_client_put_object_legal_hold():
    response = client.put_object_legal_hold(
        Bucket='string'
    )

def s3_client_put_object_lock_configuration():
    response = client.put_object_lock_configuration(
        Bucket='string'
    )
