import boto3
def lambdaFunc(event, context):

    # TP, client's credentials are being hardcoded in the function
    boto3.client(
        's3',
        aws_access_key_id='ACCESS_KEY',
        aws_secret_access_key='SECRET_KEY',
        aws_session_token='SESSION_TOKEN'
    )

    return 'Lambda Function OK'
