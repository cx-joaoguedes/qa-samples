import boto3

import json

global_counter = 0

def increaseCounter():
    global_counter = global_counter + 1

def lambdaFunc(event, context):
    increaseCounter()
    return {
        "status": 200,
        "body": json.dumps(global_counter)
    }
