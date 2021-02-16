package repositores

import models.Person
import slick.jdbc.MySQLProfile.api._

import java.util.UUID

object SlickTables {

  class PersonTables(tag: Tag) extends Table[Person](tag,"person"){

    def id: Rep[UUID] = column[UUID]("id", O.PrimaryKey, O.SqlType("binary(16)"))
    def username: Rep[String] = column[String]("username")
    def email: Rep[Option[String]] = column[Option[String]]("email")

    override def * = (id, username, email) <> ((Person.apply _).tupled, Person.unapply)
  }

}
