package spark

import org.apache.spark.SparkConf
import org.apache.spark.streaming._
import org.apache.spark.streaming.kafka._
import org.apache.spark.SparkContext
import org.apache.spark.streaming.dstream.DStream


class SparkStream(args: Array[String]) {


  def countWords(): DStream[(String, Long)] = {
    //get the topics
    val topicMap = topics.split(",").map((_, numThreads.toInt)).toMap

    // Create an input stream that pulls messages from Kafka Brokers
    val lines = KafkaUtils.createStream(ssc, zkQuorum, group, topicMap).map(_._2)
    val words = lines.flatMap(_.split(" "))

    words.map(x => (x, 1L)).reduceByKeyAndWindow(_ + _, _ - _, Minutes(10), Seconds(2), 2)
  }


//  val Array(zkQuorum, group, topics, numThreads) = args

  val zkQuorum = args(1)
  val group = args(2)
  val topics = args(3)
  val numThreads = args(4)

  val conf = new SparkConf().setMaster("local[4]").setAppName("Consumer")
  conf.set("spark.executor.memory", "4g")
  conf.set("spark.storage.memoryFraction", "0.8")
  conf.set("spark.driver.memory", "2g")
  val sparkConf = new SparkContext(conf)

  val ssc = new StreamingContext(sparkConf, Seconds(2))
  ssc.checkpoint("checkpoint")


  countWords().print(100)

  ssc.start()
  ssc.awaitTermination()


}