import boto3

client = boto3.client("s3")
paginator = client.get_paginator('list_parts')

def lambdaFunc(event, context):
    KEY = b"this_is_a_secret_key"

    paginator.paginate(SSECustomerKey=KEY)