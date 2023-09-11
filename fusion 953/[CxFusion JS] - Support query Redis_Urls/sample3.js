const redis = require('redis');
const config = {
  host: '127.0.0.1',           // Redis host
  port: 6379,                  // Redis port
  password: 'auth',            // Redis password (optional)
  db: 0,                       // Redis database index (optional)
  family: 4,                   // IP version (4 or 6)
  disable_resubscribing: false,// Whether to automatically resubscribe after reconnecting (default: false)
  retry_strategy: function(options) {
    return Math.min(options.attempt * 100, 3000);
  },
};

const client = redis.createClient(config);

client.on('connect', function() {
    console.log('Redis client connected');
});

client.on('error', function (err) {
    console.log('Something went wrong ' + err);
});