import boto3
import json

def lambdaFunc(event, context):
    session = boto3.Session()
    print(session.get_credentials().access_key) # Result
    return {
        'statusCode': 200,
        'body': json.dumps(session.get_credentials().secret_key) # Result
    }