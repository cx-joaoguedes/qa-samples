#import boto3
#sqs = boto3.client('sqs', region_name='us-west-2')
from boto3 import client

sqs = client('sqs', region_name='us-west-2')

queue_url = 'https://sqs.us-west-2.amazonaws.com/123456789012/my-queue'
message_body = 'Hello, SQS!'

response = sqs.send_message(QueueUrl=queue_url, MessageBody=message_body)
