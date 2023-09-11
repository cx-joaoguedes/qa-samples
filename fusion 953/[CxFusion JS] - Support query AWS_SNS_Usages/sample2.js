const AWS = require('aws-sdk');

const sns = new AWS.SNS({
  accessKeyId: 'YOUR_ACCESS_KEY_ID',
  secretAccessKey: 'YOUR_SECRET_ACCESS_KEY',
  region: 'YOUR_REGION'
});

const params = {
  TopicArn: 'arn:aws:sns:YOUR_REGION:YOUR_ACCOUNT_ID:my-topic',
  Message: 'Hello, world!'
};

sns.publish(params, (err, data) => {
  if (err) console.error(err);
  else console.log(`Message published: ${data.MessageId}`);
});
