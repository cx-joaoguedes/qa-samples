import boto3

def lambdaFunc(event, context):
    client = boto3.client("dynamodb")
    response = client.transact_get_items(
    TransactItems=[
        {
            'Get': {
                'Key': {
                    'string': {
                        'S': 'string',
                        'N': 'string',
                        'B': b'bytes',
                        'SS': [
                            'string',
                        ],
                        'NS': [
                            'string',
                        ],
                        'BS': [
                            b'bytes',
                        ],
                        'M': {
                            'string': {'... recursive ...'}
                        },
                        'L': [
                            {'... recursive ...'},
                        ],
                        'NULL': True|False,
                        'BOOL': True|False
                    }
                },
                'TableName': 'string',
                'ProjectionExpression': 'string',
                'ExpressionAttributeNames': {
                    'string': 'string'
                }
            }
        },
    ],
    ReturnConsumedCapacity='INDEXES'|'TOTAL'|'NONE'
    )

    return response['Responses']
