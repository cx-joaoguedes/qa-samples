import boto3

sns = boto3.client('sns', region_name='us-west-2')

response = sns.subscribe(
    TopicArn='arn:aws:sns:us-west-2:123456789012:MyTopic',
    Protocol='sms',
    Endpoint='+1234567890'
)

print(response)
