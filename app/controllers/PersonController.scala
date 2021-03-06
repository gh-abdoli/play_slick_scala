package controllers

import controllers.forms.PersonForm
import models.{Address, Person}
import play.api.mvc.{MessagesBaseController, MessagesControllerComponents}
import services.PersonService

import java.util.UUID
import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class PersonController @Inject()(val controllerComponents: MessagesControllerComponents, personService: PersonService) extends MessagesBaseController {

  def insert = Action.async { implicit request => {
    PersonForm.form.bindFromRequest().fold(
      error => Future.successful(Ok("error")),
      res => {
        personService.insert(Person(UUID.randomUUID(), res.username, res.email))
        Future.successful(Redirect(routes.HomeController.index()).flashing("error" -> "Hellow Ghasem"))
      }
    )
  }
  }

  def personList = Action.async {
    implicit request => {
      val limit: Long = request.getQueryString("limit").map(_.toLong).getOrElse(50)
      val offset: Long = request.getQueryString("offset").map(_.toLong).getOrElse(0)
      personService.allPersons(limit, offset) map { person =>
        Ok(views.html.personlist(person))
        //Ok(Json.stringify(Json.toJson(Json.toJson(person))))
      }

    }
  }

  def delete(id: UUID) = Action {
    personService.delete(id)
    Redirect(routes.HomeController.index())
  }
}