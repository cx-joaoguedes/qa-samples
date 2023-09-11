import boto3

client = boto3.client('dynamodb')

def lambda_handler(event, context):
    user_input = event['user_input'] 
    
    client.batch_write_item(RequestItems={
        'users': [{'PutRequest':{
            'Item': {
                'username': {'S': user_input},
                'name': {'S': user_input}}}}]})
    