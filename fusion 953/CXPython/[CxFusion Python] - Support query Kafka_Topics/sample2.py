import boto3

client = boto3.client('kafka')

response = client.create_cluster(
    BrokerNodeGroupInfo={
        'BrokerAZDistribution': 'DEFAULT',
        'ClientSubnets': [
            'subnet-11111111',
            'subnet-22222222'
        ],
        'InstanceType': 'kafka.m5.large',
        'SecurityGroups': [
            'sg-11111111',
            'sg-22222222'
        ],
        'StorageInfo': {
            'EbsStorageInfo': {
                'VolumeSize': 1000
            }
        }
    },
    ClusterName='my-msk-cluster',
    EncryptionInfo={
        'EncryptionAtRest': {
            'DataVolumeKMSKeyId': 'alias/aws/kafka'
        },
        'EncryptionInTransit': {
            'ClientBroker': 'TLS',
            'InCluster': True
        }
    },
    EnhancedMonitoring='PER_TOPIC_PER_BROKER',
    KafkaVersion='2.2.1',
    NumberOfBrokerNodes=3
)

print(response)
