import boto3
import json

client = boto3.client("s3control")
def lambdaFunc(event, context):
    user_input = event['user_input']

    details= {
        'Name':'test',
        'Policy': user_input
    }

    client.put_multi_region_access_point_policy(Details=details)    # Result