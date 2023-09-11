import boto3

client = boto3.client('dynamodb')

def lambda_handler(event, context):
    user_input = event['user_input'] 
    
    client.update_item(
        TableName='users',
        Key={'username': {'S': 'test'},
             'name': {'S': user_input}})
    