package com.yadu.alpakka.mongo

import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.mongodb.scala.bson.codecs.DEFAULT_CODEC_REGISTRY
import org.mongodb.scala.bson.codecs.Macros._

/**
 * Created by yadu on 10/09/20
 */


object CodecRegistry {
  val vehicleCodec = fromRegistries(fromProviders(classOf[VehicleData],classOf[GPSLocation]), DEFAULT_CODEC_REGISTRY)
  val engineCodec  = fromRegistries(fromProviders(classOf[EngineParams]), DEFAULT_CODEC_REGISTRY)
}
