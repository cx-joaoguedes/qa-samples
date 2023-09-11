import boto3

client = boto3.client('kafka')

response = client.list_nodes(
    ClusterArn='arn:aws:kafka:us-east-1:111122223333:cluster/my-msk-cluster'
)

print(response)
