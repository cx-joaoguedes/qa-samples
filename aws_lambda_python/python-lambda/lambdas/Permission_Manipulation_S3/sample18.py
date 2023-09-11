import boto3

s3 = boto3.resource('s3')
object_acl = s3.ObjectAcl('bucket_name','object_key')

def lambdaFunc(event, context):
    user_input = event['user_input']

    object_acl.owner = user_input # result