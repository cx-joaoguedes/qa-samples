const Stomp = require("stomp-client");

const client = new Stomp("localhost", 61613, "admin", "password");

client.connect(function (sessionId) {
  console.log(`Connected to ActiveMQ STOMP server with session ID: ${sessionId}`);
});
