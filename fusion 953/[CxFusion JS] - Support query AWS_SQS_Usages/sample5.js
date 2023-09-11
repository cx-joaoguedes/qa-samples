const AWS = require('aws-sdk');

const sqs = new AWS.SQS({ region: 'us-west-2' });
const queueUrl = 'https://sqs.us-west-2.amazonaws.com/123456789012/testQueue';

const deleteMessage = async (receiptHandle) => {
  const params = {
    QueueUrl: queueUrl,
    ReceiptHandle: receiptHandle,
  };

  try {
    await sqs.deleteMessage(params).promise();
    console.log(`Message deleted: ${receiptHandle}`);
  } catch (error) {
    console.error(error);
  }
};

// Call deleteMessage function with the receipt handle of the message to be deleted
deleteMessage('receipt-handle-value');
