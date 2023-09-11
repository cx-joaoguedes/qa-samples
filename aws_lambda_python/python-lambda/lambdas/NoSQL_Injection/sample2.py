import boto3

session = boto3.Session(profile_name='mfa')
client = session.client('dynamodb')

# TP
def lambdaFunc(event, context):
    user_input = event['user_input']
    client.batch_execute_statement(Statement="SELECT * FROM users WHERE username='" + user_input + "'")


# TN
def lambdaFunc(event, context):
    user_input = event['user_input']
    client.batch_execute_statement(
        Statement="SELECT * FROM users WHERE username=?",
        Parameters=[{'S': user_input}])
