const amqp = require("amqplib");

amqp
  .connect("amqp://localhost")
  .then(conn => {
    return conn.createChannel();
  })
  .then(channel => {
    const exchange = "test-exchange";
    const queue = "test-queue";

    channel.assertExchange(exchange, "fanout", { durable: false });
    channel.assertQueue(queue, { exclusive: true });
    channel.bindQueue(queue, exchange, "");

    console.log(" [x] Waiting for messages in %s", queue);
    channel.consume(queue, msg => {
      console.log(" [x] Received %s", msg.content.toString());
    }, { noAck: true });
  });
