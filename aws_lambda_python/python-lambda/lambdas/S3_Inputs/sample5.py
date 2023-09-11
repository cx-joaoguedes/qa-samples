import boto3

clientControl = boto3.client('s3control')

## 3rd Order Inputs

def s3_control_client():
    describe_job = clientControl.describe_job()  # Input 1
    get_access_point = clientControl.get_access_point()  # Input 2
    get_access_point_configuration_for_object_lambda = clientControl.get_access_point_configuration_for_object_lambda()  # Input 3
    get_bucket_lifecycle_configuration = clientControl.get_bucket_lifecycle_configuration()  # Input 4
    get_job_tagging = clientControl.get_job_tagging()  # Input 5
    get_multi_region_access_point = clientControl.get_multi_region_access_point()  # Input 6
    get_storage_lens_configuration = clientControl.get_storage_lens_configuration()  # Input 7
    get_storage_lens_configuration_tagging = clientControl.get_storage_lens_configuration_tagging()  # Input 8
    list_access_points = clientControl.list_access_points()  # Input 9
    list_access_points_for_object_lambda = clientControl.list_access_points_for_object_lambda()  # Input 10
    list_jobs = clientControl.list_jobs()  # Input 11
    list_regional_buckets = clientControl.list_regional_buckets()  # Input 12
    list_storage_lens_configurations = clientControl.list_storage_lens_configurations()  # Input 13
