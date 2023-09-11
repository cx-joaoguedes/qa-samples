import boto3

sns = boto3.client('sns', region_name='us-west-2')

response = sns.create_platform_endpoint(
    PlatformApplicationArn='arn:aws:sns:us-west-2:123456789012:app/GCM/MyApp',
    Token='1234567890123456789012345678901234567890123456789012345678901234',
    CustomUserData='My custom data'
)

print(response)
