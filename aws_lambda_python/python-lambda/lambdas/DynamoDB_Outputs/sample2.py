import boto3


client = boto3.client('dynamodb')

def lambda_handler(event, context):
    user_input = event['user_input'] 
    
    client.batch_execute_statement(
        Statements=[{
            'Statement': "INSERT INTO users VALUE {'username': ?, 'name': ?}",
            'Parameters':[{'S': user_input},
                          {'S': user_input}]}])