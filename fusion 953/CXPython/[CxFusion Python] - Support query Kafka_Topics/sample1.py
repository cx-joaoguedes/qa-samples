import boto3

client = boto3.client('kafka')

response = client.batch_associate_scram_secret(
    ClusterArn='arn:aws:kafka:us-west-2:123456789012:cluster/my-cluster',
    SecretArnList=['arn:aws:secretsmanager:us-west-2:123456789012:secret:my-secret-arn-1','arn:aws:secretsmanager:us-west-2:123456789012:secret:my-secret-arn-2']
)

print(response)
