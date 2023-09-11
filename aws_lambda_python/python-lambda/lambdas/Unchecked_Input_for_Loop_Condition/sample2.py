# Using Lambda's parameters to control while loop frequency

# TP // The user could pass a big value to perform DOS
def lambdaFunc(event, context):
    params = event['queryStringParameters']
    loop_range = int(params["range"])
    i = 0
    while i < loop_range:
        print("working on something")
    return "Lambda Function OK"


# TN // The user cannot pass a big value to perform DOS because there is an input limit check
def lambdaFuncTN(event, context):
    params = event['queryStringParameters']
    loop_range = int(params["range"])
    loop_limit = 20

    if loop_range > loop_limit:
        loop_range = loop_limit

    i = 0
    while i < loop_range:
        print("working on something")
    return "Lambda Function OK"