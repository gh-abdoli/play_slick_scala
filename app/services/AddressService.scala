package services

import models.Address
import repositores.AddressRepository

import javax.inject.Inject
import scala.concurrent.Future

class AddressService @Inject()(repo: AddressRepository) {

  def insert(address: Address): Future[Address] = {
    repo.insert(address)
  }
  def allPersons(limit: Long, offset: Long): Future[Seq[Address]] = {
    repo.allAddresses(limit, offset)
  }

  def delete(id: Long): Future[Long] = {
    repo.delete(id)
  }

}
