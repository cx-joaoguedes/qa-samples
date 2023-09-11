import boto3

sns = boto3.client('sns', region_name='us-west-2')

response = sns.create_sms_sandbox_phone_number(
    PhoneNumber='1234567890'
)

print(response)
