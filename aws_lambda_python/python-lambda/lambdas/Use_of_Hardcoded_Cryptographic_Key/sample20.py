import boto3

s3 = boto3.resource('s3')
bucket = s3.Bucket('mybucket')
obj = bucket.Object('mykey')

def lambdaFunc(event, context):
    KEY = b"this_is_a_secret_key"

    obj.initiate_multipart_upload(SSECustomerKey=KEY)