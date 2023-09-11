import boto3

client = boto3.client("s3")
def lambdaFunc(event, context):
    KEY = b"this_is_a_secret_key"

    client.create_multipart_upload(SSECustomerKey=KEY)