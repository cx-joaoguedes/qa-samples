const redis = require('redis');
const client = redis.createClient({
  host: '127.0.0.1',   // Redis host
  port: 6379,          // Redis port
  password: 'auth',    // Redis password (optional)
  db: 0                // Redis database index (optional)
});

client.on('connect', function() {
    console.log('Redis client connected');
});

client.on('error', function (err) {
    console.log('Something went wrong ' + err);
});