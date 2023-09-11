import boto3
import os
import dotenv
dotenv.load_dotenv('./.env')

def lambdaFunc(event, context):
    # TN, client's credentials are being stored in .env file
    client = boto3.client(
        's3',
        aws_access_key_id = os.getenv('AWS_ACCESS_KEY_ID'),
        aws_secret_access_key = os.getenv('AWS_SECRET_ACCESS_KEY'),
        aws_session_token = os.getenv('AWS_SESSION_TOKEN')
    )

    # TP, client's credentials are being stored in .env file
    session = boto3.Session(
        's3',
        aws_access_key_id = os.getenv('AWS_ACCESS_KEY_ID'),
        aws_secret_access_key = os.getenv('AWS_SECRET_ACCESS_KEY'),
        aws_session_token = os.getenv('AWS_SESSION_TOKEN')
    )

    return 'Lambda Function OK'