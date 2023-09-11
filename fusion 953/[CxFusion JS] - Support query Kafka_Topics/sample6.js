const { Kafka } = require("@aws-sdk/client-kafka");

const kafka = new Kafka({
  region: "us-west-2",
});

async function createCluster() {
  try {
    const response = await kafka.createCluster({
      ClusterName: "my-cluster",
      BrokerNodeGroupInfo: {
        BrokerAZDistribution: "DEFAULT",
        ClientSubnets: ["subnet-12345678", "subnet-87654321"],
        InstanceType: "kafka.m5.large",
        SecurityGroups: ["sg-12345678"],
      },
      EncryptionInfo: {
        EncryptionInTransit: {
          ClientBroker: "TLS",
          InCluster: true,
        },
      },
      NumberOfBrokerNodes: 3,
    }).promise();
    console.log(`Cluster Arn: ${response.ClusterArn}`);
  } catch (err) {
    console.error(`Error: ${err}`);
  }
}

createCluster();
