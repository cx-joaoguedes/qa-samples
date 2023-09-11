import boto3

def lambdaFunc(event, context):
    client = boto3.resource("dynamodb")

    response = client.batch_get_item(
    RequestItems={
        'string': {
            'Keys': [
                {
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
            ],
            'AttributesToGet': [
                'string',
            ],
            'ConsistentRead': True|False,
            'ProjectionExpression': 'string',
            'ExpressionAttributeNames': {
                'string': 'string'
            }
        }
    },
    ReturnConsumedCapacity='INDEXES'|'TOTAL'|'NONE'
)

    return response['Responses']
