import boto3

client = boto3.client('s3')
resource = boto3.resource('s3')

def lambdaFunc(event, context):
    res = client.get_object(Bucket="bucket_name", Key="object_key_name")
    res["Body"].read()


def lambdaFunc2(event, context):
    res = client.get_object_torrent(Bucket="bucket_name", Key="object_key_name")
    res["Body"].read()

def lambdaFunc3(event, context):
    res = client.select_object_content(
        Bucket='bucket_name',
        Key='object_key_name',
        ExpressionType='SQL',
        Expression="SELECT * FROM S3Object",
        InputSerialization={'CSV': {}},
        OutputSerialization={'CSV': {}},
    )
    for event in res['Payload']:
        if 'Records' in event:
            object_content = event['Records']['Payload']  # Input

def lambdaFunc4(event, context):
    obj = resource.Object('bucket_name', 'object_key_name')
    response = obj.get()['Body'].read()  # Input

def lambdaFunc5(event,context):
    obj = resource.ObjectSummary('bucket_name', 'object_key_name')
    response = obj.get()['Body'].read()  # Input
