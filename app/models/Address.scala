package models

import play.api.libs.json.{Json, OFormat}

import java.util.UUID

case class Address(id: Long, street: String, city: String, personId: UUID)

object Address {
  implicit val addressFormat: OFormat[Address] = Json.format[Address]
}