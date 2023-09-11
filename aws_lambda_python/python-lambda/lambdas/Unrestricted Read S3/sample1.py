import boto3
import json

client = boto3.client("s3")

# TP
def lambdaFunc(event, context):
    response = client.get_object(Bucket='bucket', Key=event['object'])  # Result
    return {
        'statusCode': 200,
        'body': json.dumps(response['Body'].read().decode())
    }

# TN
def lambdaFunc(event, context):
    user_id = get_user_id()  # Can be from AWS Cognito or a custom implementation
    response = client.get_object(Bucket='bucket', Key=event['object'])
    obj_data = ''
    if response['Metadata']['user_id'] == user_id:  # The object user_id metadata is verified before accessing the object data
        obj_data = response['Body'].read()
    return {
        'statusCode': 200,
        'body': json.dumps(obj_data)
    }