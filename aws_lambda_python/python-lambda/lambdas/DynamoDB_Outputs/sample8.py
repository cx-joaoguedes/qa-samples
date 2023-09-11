import boto3

client = boto3.client('dynamodb')

def lambda_handler(event, context):
    user_input = event['user_input'] 
    
    client.transact_write_items(
        TransactItems=[
            {'Put': {'Item': { 'username': {'S': user_input},
                               'name': {'S': user_input},
                               'admin': {'BOOL': True}},
                    'TableName': 'users'}}])
    