import boto3

sns = boto3.client('sns', region_name='us-west-2')

response = sns.create_platform_application(
    Name='MyApp',
    Platform='GCM',
    Attributes={
        'PlatformCredential': 'YOUR_PLATFORM_CREDENTIAL',
        'PlatformPrincipal': 'YOUR_PLATFORM_PRINCIPAL'
    }
)

print(response)
