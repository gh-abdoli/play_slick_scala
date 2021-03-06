import repositores.Connection
import repositores.SlickTables.{AddressTables, PersonTables}
import slick.lifted.TableQuery

package object models {

  lazy val db = Connection.db
  lazy val personTables = TableQuery[PersonTables]
  lazy val addressTables = TableQuery[AddressTables]
}
