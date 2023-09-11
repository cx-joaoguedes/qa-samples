const { Kafka } = require("@aws-sdk/client-kafka");

const kafka = new Kafka({
  region: "us-west-2",
});

async function describeCluster() {
  try {
    const response = await kafka.describeCluster({ ClusterArn: "my-cluster-arn" }).promise();
    console.log(`Cluster Info: ${JSON.stringify(response.ClusterInfo)}`);
  } catch (err) {
    console.error(`Error: ${err}`);
  }
}

describeCluster();
