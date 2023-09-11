const { Kafka } = require("@aws-sdk/client-kafka");

const kafka = new Kafka({
  region: "us-west-2",
});

async function getBootstrapBrokers() {
  try {
    const response = await kafka.getBootstrapBrokers({ ClusterArn: "my-cluster-arn" }).promise();
    console.log(`Bootstrap Brokers: ${response.BootstrapBrokerString}`);
  } catch (err) {
    console.error(`Error: ${err}`);
  }
}

getBootstrapBrokers();
