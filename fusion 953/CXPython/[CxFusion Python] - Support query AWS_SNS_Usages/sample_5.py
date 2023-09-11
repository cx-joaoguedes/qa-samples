#import boto3

#sns = boto3.client('sns', region_name='us-west-2')

from boto3 import resource

sns = resource('sns')


response = sns.publish(
    TopicArn='arn:aws:sns:us-west-2:123456789012:MyTopic',
    Message='Hello world!'
)

print(response)
