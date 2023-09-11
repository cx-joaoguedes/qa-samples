import boto3

sqs = boto3.client('sqs', region_name='us-west-2')
queue_url = 'https://sqs.us-west-2.amazonaws.com/123456789012/my-queue'
receipt_handle = 'AQEBzCcTPuN...'

sqs.delete_message(QueueUrl=queue_url, ReceiptHandle=receipt_handle)
