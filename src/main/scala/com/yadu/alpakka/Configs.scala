package com.yadu.alpakka

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

/**
 * Created by yadu on 11/09/20
 */


object Configs {

  implicit val actorSystem = ActorSystem("Alpakka")
  implicit val materializer = ActorMaterializer()

  val filePath    = "vehicle_data.log"

}
