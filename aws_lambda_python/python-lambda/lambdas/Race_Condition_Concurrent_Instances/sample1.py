import boto3

import json

global_counter = 0
def lambdaFunc(event, context):
    global_counter = global_counter + 1
    return {
        "status": 200,
        "body": json.dumps(global_counter)
    }
