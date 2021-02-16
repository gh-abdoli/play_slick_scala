package repositores

import models.{Person, db, personTables}
import play.api.libs.json.JsPath.json
import play.api.libs.json.{JsPath, Json}
import repositores.SlickTables.PersonTables
import slick.jdbc.MySQLProfile.api._
import slick.lifted.TableQuery

import java.util.UUID
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

class PersonRepository {

  //lazy val db = Connection.db
  //lazy val personTables = TableQuery[PersonTables]

  def insert(person: Person): Future[Person] = {
    //Await.result(db.run(personTables.schema.create), 2 seconds)
    db.run {
      personTables += person
  }.map( _ => person)
  }

  def allPersons(limit: Long, offset: Long):Future[Seq[Person]] =  {
    db.run(personTables.drop(offset).take(limit + offset).result)
  }

  def delete(id: UUID): Future[UUID] = {
    db.run(personTables.filter(_.id === id).delete).map(_ => id)
  }
}
