import boto3

def lambdaFunc(event, context):
    client = boto3.client("dynamodbstreams")
    records = client.get_records(ShardIterator='shard1', Limit=123)

    return records['Response']