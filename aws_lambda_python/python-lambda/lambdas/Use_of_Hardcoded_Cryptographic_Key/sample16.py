import boto3

s3 = boto3.resource('s3')
multipart_upload = s3.MultipartUpload('bucket_name','object_key','id')

def lambdaFunc(event, context):
    KEY = b"this_is_a_secret_key"

    multipart_upload.filter(SSECustomerKey=KEY)