const { Kafka } = require("@aws-sdk/client-kafka");

const kafka = new Kafka({
  region: "us-west-2",
});

async function describeClusterOperation() {
  try {
    const response = await kafka.describeClusterOperation({ ClusterArn: "my-cluster-arn", OperationArn: "my-operation-arn" }).promise();
    console.log(`Cluster Operation Info: ${JSON.stringify(response.ClusterOperationInfo)}`);
  } catch (err) {
    console.error(`Error: ${err}`);
  }
}

describeClusterOperation();
