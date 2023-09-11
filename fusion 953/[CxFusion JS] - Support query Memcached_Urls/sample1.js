const memcached = require('memcached');

const memcachedClient = new memcached('127.0.0.1:11211');

memcachedClient.connect('127.0.0.1:11211', (err) => {
  if (err) console.error(err);
  else console.log('Connected to Memcached server');
});

const Memjs = require('memjs');

const memcachedClient_memjs = Memjs.Client.create('127.0.0.1:11211');

memcachedClient_memjs.get('my-key', (err, value, key) => {
  if (err) console.error(err);
  else console.log(`Value for key "${key}" is "${value}"`);
});
