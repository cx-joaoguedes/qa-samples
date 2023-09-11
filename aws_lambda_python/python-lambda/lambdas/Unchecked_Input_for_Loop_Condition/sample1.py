# Using Lambda's parameters to control for loop frequency

# TP // The user could pass a big value to perform DOS
def lambdaFunc(event, context):
    params = event['queryStringParameters']
    for x in range(int(params["range"])):
        print(x)
    return "Lambda Function OK"


# TN // The user cannot pass a big value to perform DOS because there is an input limit check
def lambdaFuncTN(event, context):
    params = event['queryStringParameters']
    loop_range = int(params["range"])
    loop_limit = 20

    if loop_range > loop_limit:
        loop_range = loop_limit

    for x in range(loop_limit):
        print(x)
    return "Lambda Function OK"