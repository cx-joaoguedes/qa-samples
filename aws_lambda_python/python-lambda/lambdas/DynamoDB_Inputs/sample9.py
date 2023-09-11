import boto3

def lambdaFunc(event, context):
    client = boto3.client("dynamodb")
    response = client.execute_transaction(
    TransactStatements=[
        {
            'Statement': 'string',
            'Parameters': [
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
            ]
        },
    ],
    ClientRequestToken='string',
    ReturnConsumedCapacity='INDEXES'|'TOTAL'|'NONE'
    )

    return response['Responses']
