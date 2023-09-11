const redis = require("redis");
const { createClient } = require("redis");

const REDIS_HOSTNAME = '127.0.0.1'; //1x Result
const REDIS_HOST = 'localhost';
const REDIS_PORT = 6379;
const REDIS_URL = 'redis://localhost:6379';

const redisClient = redis.createClient({ //4x Results
    host: REDIS_HOST,
    port: REDIS_PORT
});

const redisClient2 = createClient({ //4x Results
    url: REDIS_URL,
    socket: {
        servername: REDIS_HOST,
    }
});