package repositores

import models.{Address, Person, addressTables, personTables}
import slick.jdbc.MySQLProfile.api._

import java.util.UUID

object SlickTables {

  class PersonTables(tag: Tag) extends Table[Person](tag,"person"){

    def id: Rep[UUID] = column[UUID]("id", O.PrimaryKey, O.SqlType("binary(16)"))
    def username: Rep[String] = column[String]("username")
    def email: Rep[Option[String]] = column[Option[String]]("email")
    override def * = (id, username, email) <> ((Person.apply _).tupled, Person.unapply)


  }

  class AddressTables(tag: Tag) extends Table[Address](tag, "address") {
    def id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey, O.Unique)
    def street: Rep[String] = column[String]("street")
    def city: Rep[String] = column[String]("city")
    def personId: Rep[UUID] = column[UUID]("person_id")

    override def * = (id, street, city, personId) <> ((Address.apply _).tupled, Address.unapply)

    def person = foreignKey("person_fk", personId, personTables)(_.id)
  }

}
