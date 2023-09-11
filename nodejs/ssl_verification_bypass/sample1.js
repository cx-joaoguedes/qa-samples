var https = require('https');

var options = {
  hostname: 'domain.com',
  port: 443,
  path: '/',
  method: 'GET',
  rejectUnauthorized: false,
  insecureHTTPParser: true
};
options.agent = new https.Agent(options);

var req = https.request(options, function(res) {
  res.on('data', function(d) {
    handleRequest(d);
  });
});
req.end();