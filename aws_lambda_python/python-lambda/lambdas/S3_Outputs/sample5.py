import boto3

clientControl = boto3.client('s3control')

## 2nd Order Outputs

def s3_control_create_bucket():
    response = clientControl.create_bucket(
        Bucket='string'
    )

def s3_control_create_job():
    response = clientControl.create_job(
        AccountId='string'
    )

def s3_control_create_multi_region_access_point():
    response = clientControl.create_multi_region_access_point(
        AccountId='string'
    )

def s3_control_put_access_point_configuration_for_object_lambda():
    response = clientControl.put_access_point_configuration_for_object_lambda(
        AccountId='string'
    )

def s3_control_put_access_point_policy():
    response = clientControl.put_access_point_policy(
        AccountId='string'
    )

def s3_control_put_access_point_policy_for_object_lambda():
    response = clientControl.put_access_point_policy_for_object_lambda(
        AccountId='string'
    )

def s3_control_put_bucket_lifecycle_configuration():
    response = clientControl.put_bucket_lifecycle_configuration(
        AccountId='string'
    )

def s3_control_put_bucket_tagging():
    response = clientControl.put_bucket_tagging(
        AccountId='string'
    )

def s3_control_put_job_tagging():
    response = clientControl.put_job_tagging(
        AccountId='string'
    )

def s3_control_put_multi_region_access_point_policy():
    response = clientControl.put_multi_region_access_point_policy(
        AccountId='string'
    )

def s3_control_put_public_access_block():
    response = clientControl.put_public_access_block(
        AccountId='string'
    )

def s3_control_put_storage_lens_configuration():
    response = clientControl.put_storage_lens_configuration(
        ConfigId='string'
    )

def s3_control_put_storage_lens_configuration_tagging():
    response = clientControl.put_storage_lens_configuration_tagging(
        ConfigId='string'
    )