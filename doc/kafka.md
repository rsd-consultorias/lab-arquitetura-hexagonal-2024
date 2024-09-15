# Mensageria - Kafka

## Principais comandos

```bash
# Generate a Cluster UUID
KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"

# Format Log Directories
bin/kafka-storage.sh format -t $KAFKA_CLUSTER_ID -c config/kraft/server.properties

# Start the Kafka Server
bin/kafka-server-start.sh config/kraft/server.properties

# Stop the Kafka Server -> Ctr+C (windows) Cmd+C (Mac)

# Delete data from environment
rm -rf /tmp/kafka-logs /tmp/zookeeper /tmp/kraft-combined-logs
```

[Get started...](https://kafka.apache.org/quickstart)