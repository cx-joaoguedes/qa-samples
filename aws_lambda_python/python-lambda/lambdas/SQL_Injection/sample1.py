import boto3

client = boto3.client('s3')
def lambdaFunc(event, context):
    user_input = event['user_input']

    client.z(
        ExpressionType='SQL',
        Expression='Select * FROM users u WHERE u.name = \'' + user_input + '\'' # Result
    )