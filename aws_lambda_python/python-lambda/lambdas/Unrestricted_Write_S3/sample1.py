import boto3

client = boto3.client("s3")
def lambdaFunc(event, context):
    user_input_data = event['user_input_data']
    user_input_key = event['user_input_key']
    response = client.put_object(Bucket='bucket', Key=user_input_key, Body=user_input_data.encode())  # Result