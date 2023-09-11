import boto3

def lambdaFunc(event, context):
    dynamodb = boto3.client('dynamodb')
    users_table = dynamodb.Table('users')
    response = users_table.get_item(
                Key={'username': 'test',
                    'name': 'Tester'})
    item = response['Item']  # Input

    return item['Item']
