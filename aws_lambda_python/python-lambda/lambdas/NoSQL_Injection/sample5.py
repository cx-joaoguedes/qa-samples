import boto3

dynamodb = boto3.resource('dynamodb')
table = dynamodb.Table('my-table')

# TP
def lambdaFunc(event, context):
    user_input = event['user_input']
    table.scan(FilterExpression=user_input)


# TN
def lambdaFunc(event, context):
    user_input = event['user_input']

    table.scan(FilterExpression='?',
        Parameters=[{'S': user_input}])
