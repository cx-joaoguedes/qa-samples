import boto3

client = boto3.client('dynamodb')

def lambda_handler(event, context):
    user_input = event['user_input'] 
    
    client.put_item(
        TableName='users',
        Item={'username': {'S': user_input},
              'name': {'S': user_input}})
    