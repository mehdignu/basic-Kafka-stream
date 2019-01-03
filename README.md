# basic-Kafka-stream
Basic Example for Spark Structured Streaming and Kafka Integration

### before running the software you need to (mac only):

## install kafka          
      $ brew install kafka
## Start Kafka server:

       $ kafka-server-start /usr/local/etc/kafka/server.properties
## create a kafka topic
       $ kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
## create a text folder and change its directory on the source code in 'kafkaProducer.scala', then you are good to go !

## Kafka Presentation

- [Slides](https://docs.google.com/presentation/d/e/2PACX-1vTBhHQn-vpGLPD_lwhyVW1LmyMAdn9XSyVrV9bvtNZ-oR9HzqmvstBBnh_7KmhCJ77HbE0HTlhHpm-h/pub?start=true&loop=false&delayms=60000) for the presentation.
