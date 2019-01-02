name := "LogAnalyse"

version := "0.1"

scalaVersion := "2.11.7"


libraryDependencies ++= {
  Seq(
    "org.apache.kafka" %% "kafka" % "1.1.0",
    "org.apache.kafka" % "kafka-clients" % "1.1.0",
    "junit" % "junit" % "4.11",
    "org.scalactic" %% "scalactic" % "3.0.5",
    "org.scalatest" %% "scalatest" % "3.0.5" % "test"



  )
}

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3" % Runtime


//use exclude("org.slf4j", "slf4j-log4j12") with spark-core to avoid stupid warnings
libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.0"
// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "1.6.0"
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka" % "1.6.0"


// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.0.0-RC3"
// https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-scala
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.6"



resolvers += Resolver.mavenLocal