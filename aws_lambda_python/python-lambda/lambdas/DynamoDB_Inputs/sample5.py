import boto3

def lambdaFunc(event, context):
    client = boto3.client("dynamodb")
    input = "joaoguedes"
    # Example 1
    client.batch_execute_statement(
    Statements=[{
        'Statement': "INSERT INTO users VALUE {'username':' " + input + "', 'name': 'Tester'"
    }])
    # Example 2
    response = client.batch_execute_statement(
            Statements=[{
                'Statement': "INSERT INTO users VALUE {'username': ?, 'name': ?}",
                'Parameters':[{'S': input},
                            {'S': input}]}])
    

    return response['Responses']