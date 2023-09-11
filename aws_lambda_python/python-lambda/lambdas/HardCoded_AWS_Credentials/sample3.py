import boto3
def lambdaFunc(event, context):

    AWS_KEY = 'AWS_ACCESS_KEY'
    AWS_SECRET = 'AWS_ACCESS_SECRET'
    AWS_TOKEN = 'AWS_SESSION_TOKEN'

    # TP, client's credentials are being hardcoded in the function
    boto3.client(
        's3',
        aws_access_key_id = AWS_KEY,
        aws_secret_access_key = AWS_SECRET,
        aws_session_token = AWS_TOKEN
    )
    

    return 'Lambda Function OK'
