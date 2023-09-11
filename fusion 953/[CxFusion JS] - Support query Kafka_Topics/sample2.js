const { Kafka } = require("@aws-sdk/client-kafka");

const kafka = new Kafka({
  region: "us-west-2",
});

async function listScramSecrets() {
  try {
    const response = await kafka.listScramSecrets({ ClusterArn: "my-cluster-arn" }).promise();
    console.log(`Scram Secrets: ${JSON.stringify(response.ScramSecrets)}`);
  } catch (err) {
    console.error(`Error: ${err}`);
  }
}

listScramSecrets();
