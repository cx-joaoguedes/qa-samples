import boto3

def lambdaFunc(event, context):
    dynamodb = boto3.resource('dynamodb')
    response = dynamodb.batch_get_item(
            RequestItems={
                'users': {
                    'Keys': [{'username': 'test',
                            'name': 'Tester'}]}})
    items = response['Responses']  # Input
    return items['Responses']
