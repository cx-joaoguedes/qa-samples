import boto3

def lambdaFunc(event, context):
    client = boto3.client("dynamodb")
    response = client.get_item(
        TableName='users',
        Key={'username':{'S':'test'}}
    )

    print(response)
    return response['Item']
