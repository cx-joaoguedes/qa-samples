import boto3

s3 = boto3.resource('s3')
bucket_acl = s3.BucketAcl('bucket_name')

def lambdaFunc(event, context):
    user_input = event['user_input']

    bucket_acl.owner = user_input # result