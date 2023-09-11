import boto3

s3 = boto3.resource('s3')
bucket = s3.Bucket('mybucket')

def lambdaFunc(event, context):
    KEY = b"this_is_a_secret_key"

    bucket.put_object(SSECustomerKey=KEY)