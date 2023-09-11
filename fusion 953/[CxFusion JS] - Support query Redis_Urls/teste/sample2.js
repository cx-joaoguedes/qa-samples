const redis = require('redis');

const new_var = 'guedes' 

const REDIS_HOSTNAME = '12345678' || '127.0.0.2';
const REDIS_PORT = process.env.REDIS_PORT || 6379;
const REDIS_PASSWORD = process.env.REDIS_PASSWORD || 'password';
const REDIS_DB = process.env.REDIS_DB || 'guedes';


const client = redis.createClient({
  host: REDIS_HOSTNAME,
  port: REDIS_PORT,
  password: REDIS_PASSWORD,
  db: REDIS_DB
});

client.on('connect', function() {
    console.log('Redis client connected');
});

client.on('error', function (err) {
    console.log('Something went wrong ' + err);
});