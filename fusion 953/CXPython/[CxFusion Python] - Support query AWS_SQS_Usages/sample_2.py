import boto3
#sqs = boto3.client('sqs', region_name='us-west-2')

session = boto3.Session(profile_name='my_profile')
sqs = session.client('sqs', region_name='us-west-2')

queue_url = 'https://sqs.us-west-2.amazonaws.com/123456789012/my-queue'

response = sqs.receive_message(QueueUrl=queue_url)
message = response['Messages'][0]
message_body = message['Body']
receipt_handle = message['ReceiptHandle']
