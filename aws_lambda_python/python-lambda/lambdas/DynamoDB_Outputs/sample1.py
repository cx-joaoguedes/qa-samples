import boto3

client = boto3.client('dynamodb')

def lambda_handler(event, context):
    user_input = event['user_input'] 
    
    client.batch_execute_statement(
      Statements=[{
        'Statement': "INSERT INTO users VALUE {'username':' " + user_input + "', 'name': 'Tester'"
      }])
    