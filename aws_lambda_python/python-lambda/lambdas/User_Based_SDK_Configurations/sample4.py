import boto3
from botocore.config import Config

def lambdaFunc(event, context):
    config = Config(region_name=event['multiValueQueryStringParameters']['region'][0])

    client = boto3.client('lambda', config = config)

    print('ok')