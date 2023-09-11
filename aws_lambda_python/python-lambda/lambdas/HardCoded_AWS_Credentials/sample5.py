import boto3
import os
import dotenv
dotenv.load_dotenv('./.env')

def lambdaFunc(event, context):
    # TN, client's credentials are being stored in .env file
    client = boto3.client('s3')

    # TP, client's credentials are being stored in .env file
    session = boto3.Session('s3')

    return 'Lambda Function OK'