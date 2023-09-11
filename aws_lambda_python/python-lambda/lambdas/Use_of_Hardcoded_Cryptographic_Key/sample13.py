import boto3

client = boto3.client("s3")
waiter = client.get_waiter('object_exists')

def lambdaFunc(event, context):
    KEY = b"this_is_a_secret_key"

    waiter.wait(SSECustomerKey=KEY)