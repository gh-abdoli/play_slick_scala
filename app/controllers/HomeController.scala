package controllers

import javax.inject._
import play.api.mvc._
import services.PersonService


import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: MessagesControllerComponents, personService: PersonService) extends MessagesBaseController {

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
  def login() = Action.async { implicit request =>
    Future.successful(Ok(views.html.login()))
  }

  def logout() = Action { implicit request: Request[AnyContent] =>
    Redirect(routes.HomeController.login()).withNewSession
  }

}
