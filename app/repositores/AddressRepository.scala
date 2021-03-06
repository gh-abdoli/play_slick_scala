package repositores

import models.{Address, addressTables, db, personTables}
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.postfixOps

class AddressRepository {

  //type query = AddressTables

  def insert(address: Address): Future[Address] = {
    //Await.result(db.run(addressTables.schema.create), 2 seconds)
    db.run(addressTables += address).map(_ => address)
  }

  def allAddresses(limit: Long, offset: Long): Future[Seq[Address]] = {
    db.run(addressTables.drop(offset).take(limit + offset).result)
  }

  def delete(id: Long): Future[Long] = {
    db.run(addressTables.filter(_.id.===(id)).delete).map(_ => id)
  }
}
