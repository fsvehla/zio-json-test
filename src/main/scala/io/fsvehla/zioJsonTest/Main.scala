package io.fsvehla.zioJsonTest

import zio.json._

object Main {
  case class Banana(curvature: Double, imported: Boolean)

  implicit val codec: JsonCodec[Banana] = DeriveJsonCodec.gen

  def main(args: Array[String]) = {
    val banana = Banana(22.5, imported = true)

    println(banana.toJson)
    println("""{ "curvature": 22.5, "imported": false }""".fromJson[Banana].fold(sys.error _, identity))
  }
}
