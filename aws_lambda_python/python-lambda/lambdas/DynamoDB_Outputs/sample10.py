from msilib import Binary
import boto3

client = boto3.resource('dynamodb')

def lambda_handler(event, context):
    user_input = event['user_input'] 
    
    response = client.batch_write_item(
    RequestItems={
        'string': [
            {
                'PutRequest': {
                    'Item': {
                        'string': user_input
                    }
                },
                'DeleteRequest': {
                    'Key': {
                        'string': user_input
                    }
                }
            },
        ]
    },
    ReturnConsumedCapacity='INDEXES'|'TOTAL'|'NONE',
    ReturnItemCollectionMetrics='SIZE'|'NONE'
    )
    return response
    