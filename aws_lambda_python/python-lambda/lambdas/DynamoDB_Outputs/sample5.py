import boto3

client = boto3.client('dynamodb')

def lambda_handler(event, context):
    user_input = event['user_input'] 
    
    client.execute_statement(
        Statement="INSERT INTO users VALUE {'username': ?, 'name': ?}",
        Parameters=[{'S': user_input},
                    {'S': user_input}])
    