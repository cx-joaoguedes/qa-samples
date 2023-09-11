import boto3
import json
from botocore.config import Config

def lambdaFunc(event, context):
    body = json.loads(event["body"])
    config = Config(region_name=body['region'])

    client = boto3.client('lambda', config = config)

    print('ok')