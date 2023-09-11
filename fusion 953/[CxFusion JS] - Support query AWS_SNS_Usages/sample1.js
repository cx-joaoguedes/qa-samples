const AWS = require('aws-sdk');

const sns = new AWS.SNS({
  accessKeyId: 'YOUR_ACCESS_KEY_ID',
  secretAccessKey: 'YOUR_SECRET_ACCESS_KEY',
  region: 'YOUR_REGION'
});

const params = {
  Name: 'my-topic'
};

sns.createTopic(params, (err, data) => {
  if (err) console.error(err);
  else console.log(`Topic created: ${data.TopicArn}`);
});