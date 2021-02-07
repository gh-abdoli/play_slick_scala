package services
import models.Person
import repositores.PersonRepository

import javax.inject.Inject
import scala.concurrent.Future

class PersonServiceImpl @Inject()(repo: PersonRepository) extends PeronService {
  override def insert(person: Person): Future[Person] = {
    repo.insert(person)
  }

  override def allPersons(limit: Long, offset: Long): Future[Seq[Person]] = {
    repo.allPersons(limit, offset)
  }

  override def delete(id: Int): Future[Int] = {
    repo.delete(id)
  }
}
