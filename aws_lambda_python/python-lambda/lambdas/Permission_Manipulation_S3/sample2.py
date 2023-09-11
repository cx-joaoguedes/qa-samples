import boto3

client = boto3.client("s3")
def lambdaFunc(event, context):
    user_input = event['user_input']

    client.create_multipart_upload(ACL=user_input,                # Result
                        GrantFullControl = user_input,  # Result
                        GrantRead=user_input,           # Result
                        GrantReadACP=user_input,        # Result
                        GrantWrite=user_input,          # Result
                        GrantWriteACP=user_input,       # Result
                        ObjectOwnership=user_input,     # Result
                        AccessControlPolicy=user_input, # Result
                        OwnershipControls=user_input,   # Result
                        Policy=user_input)              # Result