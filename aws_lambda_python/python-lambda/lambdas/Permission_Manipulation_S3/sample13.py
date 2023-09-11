import boto3

client = boto3.client("s3control")
def lambdaFunc(event, context):
    user_input = event['user_input']

    client.put_public_access_block(PublicAccessBlockConfiguration=user_input) # result