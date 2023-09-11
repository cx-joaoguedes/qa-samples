import boto3
import json 

client = boto3.client('s3')

def lambdaFunc(event, context):
    user_input = event['user_input']

    client.restore_object(
        RestoreRequest={
            'ExpressionType':'SQL',
            'Expression':'Select * FROM users u WHERE u.name = \'' + user_input + '\'' # Result
        }
    )

def lambdaFunc2(event, context):
    user_input = event['user_input']

    req_obj = {
            'ExpressionType':'SQL',
            'Expression':'Select * FROM users u WHERE u.name = \'' + user_input + '\'' # Result
    }

    client.restore_object(
        RestoreRequest= req_obj
    )