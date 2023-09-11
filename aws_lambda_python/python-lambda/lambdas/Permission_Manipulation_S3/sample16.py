import boto3

s3 = boto3.resource('s3')
bucket_policy = s3.BucketPolicy('bucket_name')

def lambdaFunc(event, context):
    user_input = event['user_input']

    bucket_policy.policy = user_input # result