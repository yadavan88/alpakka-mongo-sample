package com.yadu.alpakka.mongo

import com.mongodb.reactivestreams.client.MongoCollection

/**
 * Created by yadu on 10/09/20
 */


object Collections {

  final val connection = new MongoConnection("mongodb://localhost:27019")
  val db = connection.db

  val vehicleDataCollection: MongoCollection[VehicleData] = db.getCollection(classOf[VehicleData].getSimpleName, classOf[VehicleData])
    .withCodecRegistry(CodecRegistry.vehicleCodec)
}

object MainApp extends App {
  //  implicit val actorSystem  = ActorSystem("Alpakka-Mongo")
  //  implicit val materializer = ActorMaterializer()

  //  val vehicleData     = VehicleData(200, GPSLocation(56, 76.2345), LocalDateTime.now)
  //  val insertionResult = Source(Seq(vehicleData)).runWith(MongoSink.insertOne(Collections.vehicleDataCollection))
  //  insertionResult.map{ res =>
  //    println("Mongo record inserted successfully.. " + res)
  //  }.recover{
  //    case ex =>
  //      ex.printStackTrace()
  //  }


  //  val vehicleDataFuture = MongoSource(Collections.vehicleDataCollection.find()).runWith(Sink.seq).map{ data =>
  //    println("Vehicle Data: " + data)
  //  }.recover({
  //    case ex => ex.printStackTrace()
  //  })
  //
  //
  //  MongoSource(Collections.vehicleDataCollection.find(Filters.eq("vehicleId",200))).runWith(Sink.seq).map{
  //    r => println("Fitered => "+r)
  //  }
  //
  ////  MongoSource(Collections.vehicleDataCollection.updateOne(Filters.eq("vehicleId",200),))
  //
  //  Thread.sleep(5000)
}