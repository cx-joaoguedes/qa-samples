import boto3

def lambdaFunc(event, context):
    client = boto3.client("dynamodb")
    response = client.get_records(
    ShardIterator='string',
    Limit=123
    )

    return response['Response']
