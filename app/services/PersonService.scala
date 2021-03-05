package services
import models.Person
import repositores.PersonRepository

import java.util.UUID
import javax.inject.Inject
import scala.concurrent.Future

class PersonService @Inject()(repo: PersonRepository) {

  def insert(person: Person): Future[Person] = {
    repo.insert(person)
  }

  def allPersons(limit: Long, offset: Long): Future[Seq[Person]] = {
    repo.allPersons(limit, offset)
  }

  def delete(id: UUID): Future[UUID] = {
    repo.delete(id)
  }
}
