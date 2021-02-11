package services

import models.Person

import java.util.UUID
import scala.concurrent.Future

trait PeronService {
  def insert(person: Person): Future[Person]
  def delete(id: UUID): Future[UUID]
  def allPersons(limit: Long, offset: Long):Future[Seq[Person]]
}
