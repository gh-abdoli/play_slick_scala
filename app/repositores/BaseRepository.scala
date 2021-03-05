package repositores

import models.{Person, db, personTables}
import slick.lifted.TableQuery
import slick.relational.RelationalTableComponent

import java.util.UUID
import scala.concurrent.Future

class BaseRepository[Entity] {

  /*type TableType <: RelationalTableComponent#Table[Entity]

  var query = TableQuery[TableType]

  def insert(entity: Entity): Future[Entity] = {
    //Await.result(db.run(personTables.schema.create), 2 seconds)
    db.run {
      query += entity
    }.map( _ => entity)
  }

  def allPersons(limit: Long, offset: Long):Future[Seq[Entity]] =  {
    db.run(query.drop(offset).take(limit + offset).result)
  }

  def delete(id: Long): Future[Long] = {
    db.run(query.filter(_.id === id).delete).map(_ => id)
  }*/
}
