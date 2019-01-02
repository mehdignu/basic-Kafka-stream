package main

import kafka.kafkaProducer
import spark.SparkStream
import org.apache.log4j.Logger
import org.apache.log4j.Level


object App {


  def main(args: Array[String]): Unit = {

    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.OFF)


    if (args.length < 4) {
      System.err.println("Usage: KafkaWordCount <zkQuorum><group> <topics> <numThreads>")
      System.exit(1)
    }

    // start zookeeper: zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties

    val producer = new Thread {
      override def run {
        //start producer
        new kafkaProducer
      }
    }
    producer.start


    val consumer = new Thread {
      override def run {
        //start the consumer
        new SparkStream(args)
      }
    }
    consumer.start


    //wait for the Thread to die
    consumer.join()
    producer.join()

  }


}