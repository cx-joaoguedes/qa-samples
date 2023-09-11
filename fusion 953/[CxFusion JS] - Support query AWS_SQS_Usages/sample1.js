const AWS = require('aws-sdk');

const sqs = new AWS.SQS({ region: 'us-west-2' });

const receiveMessage = async () => {
  const params = {
    QueueUrl: 'https://sqs.us-west-2.amazonaws.com/123456789012/testQueue',
    MaxNumberOfMessages: 1,
    VisibilityTimeout: 10,
    WaitTimeSeconds: 0,
  };

  try {
    const data = await sqs.receiveMessage(params).promise();
    if (data.Messages) {
      console.log(data.Messages[0].Body);
    } else {
      console.log('No messages in the queue.');
    }
  } catch (error) {
    console.error(error);
  }
};

receiveMessage();
