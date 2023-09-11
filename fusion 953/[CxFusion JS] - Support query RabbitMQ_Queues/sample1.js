const amqp = require("amqplib");

amqp
  .connect("amqp://localhost")
  .then(conn => {
    return conn.createChannel();
  })
  .then(channel => {
    const exchange = "test-exchange";
    const msg = {
      message: "Hello, World!"
    };

    channel.assertExchange(exchange, "fanout", { durable: false });
    channel.publish(exchange, "", Buffer.from(JSON.stringify(msg)));

    console.log(" [x] Sent %s", msg);
    return channel.close();
  })
  .finally(() => {
    process.exit(0);
  });
