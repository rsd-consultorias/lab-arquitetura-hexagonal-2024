# Mensageria - Kafka

## Principais comandos

```bash
# Generate a Cluster UUID
KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"

# Format Log Directories
bin/kafka-storage.sh format -t $KAFKA_CLUSTER_ID -c config/kraft/server.properties

# Start the Kafka Server
bin/kafka-server-start.sh config/kraft/server.properties

# Stop the Kafka Server -> Ctr+C

# Delete data from environment
rm -rf /tmp/kafka-logs /tmp/zookeeper /tmp/kraft-combined-logs

# ##########################################################################################
# Create topic (quickstart-events is the topic name)
bin/kafka-topics.sh --create --topic order-events --bootstrap-server localhost:9092
bin/kafka-topics.sh --create --topic payment-events --bootstrap-server localhost:9092
bin/kafka-topics.sh --create --topic inventory-events --bootstrap-server localhost:9092

bin/kafka-topics.sh --create --topic order-events --bootstrap-server localhost:9092

# Write event in the topic (Ctr+C to stop)
bin/kafka-console-producer.sh --topic order-events --bootstrap-server localhost:9092

# Read events (Ctr+C to stop)
bin/kafka-console-consumer.sh --topic order-events --bootstrap-server localhost:9092

# Read from beginning
bin/kafka-console-consumer.sh --topic order-events --from-beginning --bootstrap-server localhost:9092


```

[Get started...](https://kafka.apache.org/quickstart)