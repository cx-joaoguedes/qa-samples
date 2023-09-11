const AWS = require('aws-sdk');

const sqs = new AWS.SQS({ region: 'us-west-2' });
const queueUrl = 'https://sqs.us-west-2.amazonaws.com/123456789012/testQueue';


// O facto de estar dentro de uma função faz com que o flow nao passe no metodo correto
const sendMessage2 = async (messageBody) => {
  const params = {
    QueueUrl: queueUrl,
    MessageBody: messageBody,
  };

  try {
    const sqs_response = await sqs.sendMessage(params).promise();
    console.log(`Message sent: ${messageBody}`);
  } catch (error) {
    console.error(error);
  }
};

sendMessage2('Hello, World!');
