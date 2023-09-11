import boto3

def lambdaFunc(event, context):
    client = boto3.client("dynamodb")
    response = client.execute_statement(
    Statement='string',
    Parameters=[
        {
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
        },
    ],
    ConsistentRead=True|False,
    NextToken='string',
    ReturnConsumedCapacity='INDEXES'|'TOTAL'|'NONE',
    Limit=123
    )

    return response['Response']
