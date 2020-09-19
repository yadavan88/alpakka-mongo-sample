package com.yadu.alpakka.mongo

import java.time.LocalDateTime

/**
 * Created by yadu on 10/09/20
 */


final case class GPSLocation(lat: Double, lng: Double)

final case class VehicleData(vehicleId: Long, location: GPSLocation)

final case class EngineParams(vehicleId: Long, temperature: Double, rpm: Long)