import json
def lambdaFunc(event,context):

    #parameters
    params1 = event['queryStringParameters']
    params2 = event['multiValueQueryStringParameters']

    print(params1)
    print(params2)

    params = {
        "params1": params1,
        "params2": params2
    }
    return {
        'body': json.dumps(params)
    }


    