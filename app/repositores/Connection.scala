package repositores

import slick.jdbc.H2Profile.api._

object Connection {
  var db = Database.forConfig("db.default")
}
