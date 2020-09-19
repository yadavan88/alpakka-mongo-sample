name := "alpakka-mongo-sample"

version := "0.1"

scalaVersion := "2.13.3"

val AkkaVersion = "2.5.31"

libraryDependencies ++= Seq(
  "com.lightbend.akka" %% "akka-stream-alpakka-mongodb" % "2.0.1",
  "com.lightbend.akka" %% "akka-stream-alpakka-slick" % "2.0.1",
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % "2.2.0",
  "org.mongodb" % "mongodb-driver-reactivestreams" % "1.12.0",
  "org.mongodb.scala" %% "mongo-scala-driver" % "2.9.0",
  "com.h2database" % "h2" % "1.4.200",
  "org.postgresql" % "postgresql" % "42.2.16",
  "com.lightbend.akka" %% "akka-stream-alpakka-file" % "2.0.2",
//  "net.manub" %% "scalatest-embedded-kafka" % "2.0.0"

)