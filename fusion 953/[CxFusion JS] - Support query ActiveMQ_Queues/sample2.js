const Stomp = require("stomp-client");

const client = new Stomp("localhost", 61613, "admin", "password");

client.connect()
  .then(sessionId => {
    console.log(`Connected to ActiveMQ STOMP server with session ID: ${sessionId}`);
  })
  .catch(err => {
    console.error(`Error: ${err}`);
  });
