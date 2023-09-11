const MEMCACHIER_SERVERS = '127.0.0.1:11211'; //1x Result
const Memcached = require('memcached');
const server = 'localhost:11211';

const memcachedClient = new Memcached([server, '192.168.0.103:11211']); //4x Results

const memcachedClient2 = new Memcached('localhost:11211'); //2x Result

const memcachedClient3 = new Memcached();
memcachedClient3.connect(server, function (err, conn) {
    if (err) console.log(conn.server, 'error while memcached connection!!');
});

const nemjs = require('memjs');
const nemjsClient = nemjs.Client.create('localhost:11211'); //2x Result

const { Client } = require('memjs');
const nemjsDirectClient = Client.create(server); //2x Result