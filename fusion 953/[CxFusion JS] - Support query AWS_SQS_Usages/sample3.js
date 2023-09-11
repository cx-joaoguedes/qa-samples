const AWS = require('aws-sdk');

const sqs = new AWS.SQS({ region: 'us-west-2' });
const queueUrl = 'https://sqs.us-west-2.amazonaws.com/123456789012/testQueue';

const getQueueAttributes = async () => {
  const params = {
    QueueUrl: queueUrl,
    AttributeNames: [
      'All'
    ],
  };

  try {
    const data = await sqs.getQueueAttributes(params).promise();
    console.log(data.Attributes);
  } catch (error) {
    console.error(error);
  }
};

getQueueAttributes();
