package com.yadu.alpakka.mongo

import com.mongodb.reactivestreams.client.MongoClients

/**
 * Created by yadu on 10/09/20
 */


class MongoConnection(url:String) {

  final val client = MongoClients.create(url)
  final val db = client.getDatabase("vehicle-tracker")

}
