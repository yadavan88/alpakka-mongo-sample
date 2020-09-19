# A sample project for Alpakka Mongo integration #

## Introduction ##
[Alpakka](https://doc.akka.io/docs/alpakka/current/) is a reactive stream-based integration toolkit built on top of akka and akka-streams. Since its arrival, it has positively impacted the integration of different systems. Using alpakka, it is very easy to implement an integration pipeline between disparate systems.

## Comparision ##
Apache Camel is one of the most popular integration libraries, and it has been around for a very long time. Camel is used in many of the large enterprise applications. Also, Camel has more than 300 components available, which covers almost any systems we can think of. 

Alpkka provides an alternative for apache camel. That is evident even in the project name(alpaca is a camelid animal). Even though Alpakka is relatively very young, it is already able to get good attention. Alpakka is built on top of Akka and Akka-streams, and follows reactive programming principles. Alpakka already has close to 50 connectors available. 

## Advantages of Alpakka over Camel ##
Even though Camel is immensely popular, Alpakka provides some good advantages. 
Camel has less type-safety, whereas Alpakka  provides it
Alpakka has easier api's for  asynchronous programming
Built-in support for streaming, and ability to apply backpressure

## Sample application using Alpakka Mongo ##
In this project, I have tried to build a simple pipeline to push an incoming set of data into MongoDB. For simplicity, I have used a growing file as the source of the data. But it may well be an IoT device using MQTT protocol or a complex Kafka system as a source. 
For this sample project, I have taken the scenario of an IoT device that tracks the GPS location of the vehicle. An Akka scheduler is used to simulate the data, by writing random information to a file. 
The Alpakka integration service reads from the file and transforms the data into the necessary format, and inserts it into a MongoDB collection. 
![Alt text](src/main/resources/flow.jpg?raw=true "Alpakka Pipeline")
The above diagram shows the flow used in this sample project. 

The file vehicle_data contains a comma-separated string representing the GPS Location of each vehicle. This is read by the connector and is transformed into a case class VehicleData. This data is then inserted into MongoDB, which can be used for further processing. Whenever a new record comes in the file, the source FileTailSource reads the content based on the provided polling interval and pushed along the Alpakka pipeline.

To do all these operations, we need just 10 lines of code, which is amazing! 

```scala
FileTailSource.lines(
  path = fs.getPath(filePath),
  maxLineSize = 5000,
  pollingInterval = 100.millis
).map(s => {
  val v = s.split(",")
  VehicleData(v(0).toLong, GPSLocation(v(1).toDouble, v(2).toDouble))
}).runWith{
  MongoSink.insertOne(vehicleCollection)
}
```

We can replace the FileSource with one of the many available sources like Kafka, MQTT, etc based on the requirements. 

## Conclusion ##
Alpakka is a very powerful integration toolkit that provides streaming by default. If Akka is already used as part of the system, then for building integration pipelines we don't need to look anywhere else. 
