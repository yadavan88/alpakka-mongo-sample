package com.yadu.alpakka

import java.nio.file.FileSystems

import akka.stream.alpakka.file.scaladsl.FileTailSource
import akka.stream.alpakka.mongodb.scaladsl.MongoSink
import com.mongodb.reactivestreams.client.MongoCollection
import com.yadu.alpakka.mongo.{Collections, GPSLocation, VehicleData}

import scala.concurrent.duration._

/**
 * Created by yadu on 19/09/20
 */

class FileMongoDBIntegration(vehicleCollection: MongoCollection[VehicleData]) {

  import Configs._

  val fs = FileSystems.getDefault

  def init() = {

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

  }
}

object IntegrationService extends App {
  val integration = new FileMongoDBIntegration(Collections.vehicleDataCollection)
  integration.init()
}