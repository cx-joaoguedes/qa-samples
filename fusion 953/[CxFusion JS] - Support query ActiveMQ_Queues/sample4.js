const Stomp = require("stomp-client");

const client = new Stomp("localhost", 61613, "admin", "password");

client.connect()
  .then(sessionId => {
    console.log(`Connected to ActiveMQ STOMP server with session ID: ${sessionId}`);

    client.subscribe("/queue/test")
      .then(({ body, headers }) => {
        console.log(`Received message: ${body}`);
      })
      .catch(err => {
        console.error(`Error: ${err}`);
      });
  })
  .catch(err => {
    console.error(`Error: ${err}`);
  });
