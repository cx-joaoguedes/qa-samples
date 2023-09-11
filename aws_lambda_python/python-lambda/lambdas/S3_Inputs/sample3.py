import boto3

client = boto3.client('s3')

## 3rd Order Inputs

def s3_client():
    bucket_acl = client.get_bucket_acl()  # Input 1
    bucket_analytics_configuration = client.get_bucket_analytics_configuration()  # Input 2
    bucket_cors = client.get_bucket_cors()  # Input 3
    bucket_intelligent_tiering_configuration = client.get_bucket_intelligent_tiering_configuration()  # Input 4
    bucket_inventory_configuration = client.get_bucket_inventory_configuration()  # Input 5
    bucket_lifecycle_configuration = client.get_bucket_lifecycle_configuration()  # Input 6
    bucket_logging = client.get_bucket_logging()  # Input 7
    bucket_metrics_configuration = client.get_bucket_metrics_configuration()  # Input 8
    bucket_notification_configuration = client.get_bucket_notification_configuration()  # Input 9
    bucket_replication = client.get_bucket_replication()  # Input 10
    bucket_website = client.get_bucket_website()  # Input 11
    object_acl = client.get_object_acl()  # Input 12
    head_object = client.head_object()
    cacheControl = head_object['CacheControl']  # Input 13
    contentDisposition = head_object['ContentDisposition']  # Input 14
    contentEncoding = head_object['ContentEncoding']  # Input 15
    contentLanguage = head_object['ContentLanguage']  # Input 16
    metadata = head_object['Metadata']  # Input 17
    list_bucket_analytics_configurations = client.list_bucket_analytics_configurations()  # Input 18
    list_bucket_intelligent_tiering_configurations = client.list_bucket_intelligent_tiering_configurations()  # Input 19
    list_bucket_inventory_configurations = client.list_bucket_inventory_configurations()  # Input 20
    list_bucket_metrics_configurations = client.list_bucket_metrics_configurations()  # Input 21
    get_bucket_tagging = client.get_bucket_tagging() # Input 22