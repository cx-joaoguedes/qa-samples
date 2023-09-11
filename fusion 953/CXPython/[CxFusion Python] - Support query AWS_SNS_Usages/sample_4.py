# import boto3

# sns = boto3.client('sns', region_name='us-west-2')

from boto3 import client

sns = client('sns')

response = sns.create_topic(
    Name='MyTopic'
)

print(response)
