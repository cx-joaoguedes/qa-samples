import logging
logger = logging.getLogger()
logger.setLevel(logging.INFO)

def lambdaFunc(event, context):
    print('## EVENT print')
    print(event)
    logger.info('## EVENT logger')
    logger.info(event)

    return 'Lambda Function OK'