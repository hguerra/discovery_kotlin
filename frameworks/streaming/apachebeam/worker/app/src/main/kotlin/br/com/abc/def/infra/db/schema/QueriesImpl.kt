// Code generated by sqlc. DO NOT EDIT.
// versions:
//   sqlc v1.19.1

package br.com.abc.def.infra.db.schema

import java.sql.Connection
import java.sql.SQLException

const val getPerson =
    """-- name: getPerson :one
SELECT id, first_name, last_name, email FROM person
WHERE id = ? LIMIT 1
"""

class QueriesImpl(private val conn: Connection) : Queries {
  @Throws(SQLException::class)
  override fun getPerson(id: Long): Person? {
    return conn.prepareStatement(getPerson).use { stmt ->
      stmt.setLong(1, id)

      val results = stmt.executeQuery()
      if (!results.next()) {
        return null
      }
      val ret =
          Person(
              results.getLong(1),
              results.getString(2),
              results.getString(3),
              results.getString(4),
          )
      if (results.next()) {
        throw SQLException("expected one row in result set, but got many")
      }
      ret
    }
  }
}
