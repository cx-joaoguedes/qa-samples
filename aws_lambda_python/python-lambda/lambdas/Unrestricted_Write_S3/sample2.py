import boto3
import botocore


client = boto3.client("dynamodb")
def lambdaFunc(event, context):
    user_id = get_user_id()  # Can be from AWS Cognito or a custom implementation
    response = None
    try:
      response = client.head_object(Bucket='bucket', Key=event['object'])
    except botocore.errorfactory.NoSuchKey:
        pass
    if not response:
        client.put_object(Bucket='bucket', Key=event['object'], Body=event['object_data'].encode())
    else:
        if response['Metadata']['user_id'] == user_id:
            client.put_object(Bucket='bucket', Key=event['object'], Body=event['object_data'].encode())~

def get_user_id():
    user_id = 'guedes'
    return user_id
