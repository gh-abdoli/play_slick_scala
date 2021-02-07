package models

import play.api.libs.json.{Json, OFormat}



case class Person(id: Int, username: String, email: Option[String])

object Person {
  implicit val personFormat: OFormat[Person] = Json.format[Person]
}