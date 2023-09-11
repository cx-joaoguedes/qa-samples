import boto3

client = boto3.client("dynamodb")

# TP
def lambdaFunc(event, context):
    user_input = event['user_input']
    client.scan(TableName='users',
        FilterExpression=user_input)


# TN
def lambdaFunc(event, context):
    user_input = event['user_input']

    client.scan(TableName='users',
        FilterExpression='attribute_exists(?)',
        Parameters=[{'S': user_input}])
