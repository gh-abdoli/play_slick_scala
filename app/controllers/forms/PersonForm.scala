package controllers.forms

import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, optional}

case class PersonData(username: String, email: Option[String])

object PersonForm {
  val form = Form(
    mapping(
      "username" -> nonEmptyText ,
      "email" -> optional(nonEmptyText)
    )(PersonData.apply)(PersonData.unapply)
  )
}
