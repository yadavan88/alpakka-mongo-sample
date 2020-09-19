package com.yadu.alpakka

/**
 * Created by yadu on 19/09/20
 */


import java.io.{File, FileWriter}
import java.nio.file.Paths

import akka.NotUsed
import akka.stream.alpakka.file.scaladsl.FileTailSource
import akka.stream.scaladsl.Source

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.Random

object VehicleDataGenerator extends App {

  import Configs._

  val logFilePath = Paths.get(filePath);
  val file        = new File(filePath)

  def write = {
    val writer = new FileWriter(file, true)
    val info   = Random.nextInt(100) + "," + Random.nextDouble() * 100 + "," + Random.nextDouble() * 100 + "\n"
    writer.write(info)
    writer.close()
  }

  actorSystem.scheduler.schedule(5.seconds, 5.second, new Runnable {
    override def run(): Unit = {
      write
    }
  })


  val lines: Source[String, NotUsed] = FileTailSource.lines(
    path = logFilePath,
    maxLineSize = 1000,
    pollingInterval = 250.millis
  )


}