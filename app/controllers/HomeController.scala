package controllers

import akka.http.scaladsl.model.HttpHeader.ParsingResult
import com.mysql.cj.x.protobuf.Mysqlx
import models.Person

import javax.inject._
import play.api._
import play.api.data.Form
import play.api.data.Forms.{date, default, email, mapping, nonEmptyText, number, optional, text, uuid}
import play.api.i18n.Messages
import play.api.libs.json.Json
import play.api.mvc.Results.Ok
import play.api.mvc._
import services.PersonServiceImpl


import java.util.UUID
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */

@Singleton
class HomeController @Inject()(val controllerComponents: MessagesControllerComponents, personService: PersonServiceImpl) extends MessagesBaseController {
  val personForm = Form(
    mapping(
      "id" -> default(uuid, UUID.randomUUID()),
      "username" -> nonEmptyText ,
      "email" -> optional(nonEmptyText)
    )(Person.apply)(Person.unapply)
  )
  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
  def login() = Action { implicit request: MessagesRequest[AnyContent] =>
    Ok(views.html.login())
  }

  def insert = Action.async { implicit request => {
    personForm.bindFromRequest().fold(
      error => Future.successful(Ok("Error")),
      res => {
        personService.insert(Person(res.id, res.username, res.email))
        Future.successful(Redirect(routes.HomeController.index()))
      }
    )
    }
  }
  def persons = Action.async {
    implicit request => {
      val limit: Long = request.getQueryString("limit").map(_.toLong).getOrElse(50)
      val offset: Long = request.getQueryString("offset").map(_.toLong).getOrElse(0)
      personService.allPersons(limit, offset) map { person =>
        Ok(views.html.tasklist1(person))
        //Ok(Json.stringify(Json.toJson(Json.toJson(person))))
      }

    }
  }
  def delete(id: UUID) = Action {
    personService.delete(id)
    Redirect(routes.HomeController.index())
  }
}
