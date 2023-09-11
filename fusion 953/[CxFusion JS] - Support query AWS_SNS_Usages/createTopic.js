var AWS = require('aws-sdk');
// Set region
AWS.config.update({region: 'REGION'});

var sns = new AWS.SNS({apiVersion: '2010-03-31'});

var params = {
  Name: 'STRING_VALUE', /* required */
  Attributes: {
    '<attributeName>': 'STRING_VALUE',
    /* '<attributeName>': ... */
  },
  DataProtectionPolicy: 'STRING_VALUE',
  Tags: [
    {
      Key: 'STRING_VALUE', /* required */
      Value: 'STRING_VALUE' /* required */
    },
    /* more items */
  ]
};
sns.createTopic(params, function(err, data) {
  if (err) console.log(err, err.stack); // an error occurred
  else     console.log(data);           // successful response
});