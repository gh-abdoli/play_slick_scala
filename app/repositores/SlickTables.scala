package repositores

import models.Person
import slick.jdbc.MySQLProfile.api._

object SlickTables {

  class PersonTables(tag: Tag) extends Table[Person](tag,"person"){

    def id: Rep[Int] = column[Int]("id", O.AutoInc , O.PrimaryKey)
    def username: Rep[String] = column[String]("username")
    def email: Rep[Option[String]] = column[Option[String]]("email")

    override def * = (id, username, email) <> ((Person.apply _).tupled, Person.unapply)
  }

}
