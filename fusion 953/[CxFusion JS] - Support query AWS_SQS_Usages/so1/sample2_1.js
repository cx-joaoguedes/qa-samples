const AWS = require('aws-sdk');

const sqs = new AWS.SQS({ region: 'us-west-2' });
const queueUrl = 'https://sqs.us-west-2.amazonaws.com/123456789012/testQueue';

const params = {
    QueueUrl: queueUrl,
    MessageBody: 'AAAAAAAAA',
};

try {
    const sqs_response = await sqs.sendMessage(params).promise();
    console.log(`Message sent: ${messageBody}`);
} catch (error) {
    console.error(error);
}

