package kafka

import java.util.Properties
import org.apache.kafka.clients.producer._
import scala.sys.process._

class kafkaProducer {

  val LOG_PATH = "/Users/mehdidridi/Desktop/boo.txt"
  val TOPIC = "test"


  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")

  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)

  // continuously read lines from tail -f
  // careful: this never returns (unless tail is externally killed)
  val tail = Seq("tail", "-f", LOG_PATH)

  tail.lineStream.foreach(lineProcessing)

  def lineProcessing(line: String): Unit = {
    // do whatever you want with that line - in this case send it to the consumer
    val record = new ProducerRecord(TOPIC, "key", line)
    producer.send(record)
  }

  producer.close()
}