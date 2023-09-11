import boto3

sns = boto3.client('sns', region_name='us-west-2')

response = sns.list_topics()

print(response)
