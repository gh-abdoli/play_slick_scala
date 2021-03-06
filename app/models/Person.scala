package models

import play.api.libs.json.{Json, OFormat}
import java.util.UUID

case class Person(id: UUID , username: String, email: Option[String])

object Person {
  implicit val personFormat: OFormat[Person] = Json.format[Person]
}