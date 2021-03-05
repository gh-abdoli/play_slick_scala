package controllers.forms

import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, uuid}

import java.util.UUID

case class AddressData(street: String, city: String, personId: UUID)

object AddressForm {
  val form = Form(
    mapping(
      "street" -> nonEmptyText,
      "city" -> nonEmptyText,
      "person_id" -> uuid
    )(AddressData.apply)(AddressData.unapply)
    )
}
