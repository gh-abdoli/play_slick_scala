package services

import models.Person

import scala.concurrent.Future

trait PeronService {
  def insert(person: Person): Future[Person]
  def delete(id: Int): Future[Int]
  def allPersons(limit: Long, offset: Long):Future[Seq[Person]]
}
