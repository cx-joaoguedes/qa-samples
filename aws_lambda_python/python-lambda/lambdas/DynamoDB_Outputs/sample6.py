import boto3

client = boto3.client('dynamodb')

def lambda_handler(event, context):
    user_input = event['user_input'] 
    
    response = client.execute_transaction(
    TransactStatements=[
        {
            'Statement': "INSERT INTO users VALUE {'username': '" + user_input + "', 'name': 'Execute'}",
            'Parameters': [
                {
                    'S': user_input,
                    'N': user_input,
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
    