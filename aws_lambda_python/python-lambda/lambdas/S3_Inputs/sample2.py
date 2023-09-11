import boto3

client = boto3.client("s3")
resource = boto3.resource("s3")
bucket = resource.Bucket("name")
bucket_tagging = resource.BucketTagging("bucket_name")
client_ctrl = boto3.client('s3control')

def lambdaFunc(event, context):
    res = client.complete_multipart_upload()
    result = res['Key']

def lambdaFunc2(event, context):
    res = client.create_multipart_upload()
    result = res['Key']

def lambdaFunc3(event, context):
    res = client.delete_objects()
    deleted = res['Deleted']
    for del_item in deleted:
        del_item['Key']

def lambdaFunc4(event, context):
    res = client.list_multipart_uploads()
    uploads = res['Uploads']
    for upl_item in uploads:
        upl_item['Key']

def lambdaFunc5(event, context):
    res = client.list_objects_versions()
    versions = res['Versions']
    for ver_item in versions:
        ver_item['Key']

def lambdaFunc6(event, context):
    res = client.list_objects_v2()
    contents = res['Contents']
    for cont_item in contents:
        cont_item['Key']

def lambdaFunc7(event, context):
    res = client.list_parts()
    result = res['Key']

def lambdaFunc8(event, context):
    res = client.get_bucket_tagging()
    tags = res['TagSet']
    for tag_item in tags:
        tag_item['Key']
        tag_item['Value']

def lambdaFunc9(event, context):
    res = client.get_object_tagging()
    tags = res['TagSet']
    for tag_item in tags:
        tag_item['Key']
        tag_item['Value']
    
def lambdaFunc10(event, context):
    res = bucket.delete_objects()
    deleted = res['Deleted']
    for del_item in deleted:
        del_item['Key']

def lambdaFunc11(event, context):
    res = bucket_tagging.tag_set()

def lambdaFunc12(event, context):
    res = client_ctrl.get_object_tagging()