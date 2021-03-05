package controllers

import controllers.forms.AddressForm
import models.Address
import play.api.mvc.{MessagesBaseController, MessagesControllerComponents}
import services.AddressService

import java.util.UUID
import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


@Singleton
class AddressController @Inject()(val controllerComponents: MessagesControllerComponents, service: AddressService) extends MessagesBaseController {

  def addressForm(id: UUID) = Action {
    Ok(views.html.addressform(id))
  }

  def add = Action.async { implicit request => {
    AddressForm.form.bindFromRequest().fold(
      error => {
        Future.successful(Ok("error"))
      },
      res => {
        service.insert(Address(0, res.city, res.street, res.personId))
        Future.successful(Redirect(routes.HomeController.index()).flashing("error" -> "Hellow Ghasem"))
      }
    )
  }
  }

  def addressList = Action.async {
    implicit request => {
      val limit: Long = request.getQueryString("limit").map(_.toLong).getOrElse(50)
      val offset: Long = request.getQueryString("offset").map(_.toLong).getOrElse(0)
      service.allPersons(limit, offset) map { address =>
        Ok(views.html.addresslist(address))
        //Ok(Json.stringify(Json.toJson(Json.toJson(person))))
      }
    }
  }

  def delete(id: Long) = Action {
    service.delete(id)
    Redirect(routes.HomeController.index())
  }
}