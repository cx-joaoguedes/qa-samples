import boto3

sns = boto3.client('sns', region_name='us-west-2')

response = sns.list_tags_for_resource(
    ResourceArn='arn:aws:sns:us-west-2:123456789012:MyTopic'
)

print(response)
