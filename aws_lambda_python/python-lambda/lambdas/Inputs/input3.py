import json
def lambdaFunc(event,context):

    # body
    body = json.loads(event["body"])

    print(body)


    return {
        'body': json.dumps(body)
    }
