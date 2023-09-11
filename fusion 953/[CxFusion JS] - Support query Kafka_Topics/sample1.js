const { Kafka } = require("@aws-sdk/client-kafka");

const kafka = new Kafka({
  region: "us-west-2",
});

async function listClusters() {
  try {
    const response = await kafka.listClusters().promise();
    console.log(`Clusters: ${JSON.stringify(response.ClusterInfoList)}`);
  } catch (err) {
    console.error(`Error: ${err}`);
  }
}

listClusters();