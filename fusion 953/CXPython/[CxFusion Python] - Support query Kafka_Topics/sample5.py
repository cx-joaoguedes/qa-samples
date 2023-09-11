import boto3

client = boto3.client('kafka')

response = client.list_clusters()

print(response)
