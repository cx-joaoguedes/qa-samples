const AWS = require('aws-sdk');

const sqs = new AWS.SQS({ region: 'us-west-2' });
const queueUrl = 'https://sqs.us-west-2.amazonaws.com/123456789012/testQueue';

const purgeQueue = async () => {
  const params = {
    QueueUrl: queueUrl,
  };

  try {
    await sqs.purgeQueue(params).promise();
    console.log(`Queue purged: ${queueUrl}`);
  } catch (error) {
    console.error(error);
  }
};

purgeQueue();
