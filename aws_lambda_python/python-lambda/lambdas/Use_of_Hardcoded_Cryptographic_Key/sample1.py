import boto3

client = boto3.client("s3")
def lambdaFunc(event, context):
    KEY = b"this_is_a_secret_key"

    client.put_object(Bucket='bucket_name', Key='object_name', 
          Body=b'testingdataencryption', 
          SSECustomerKey=KEY,     # Result
          SSECustomerAlgorithm='AES256')