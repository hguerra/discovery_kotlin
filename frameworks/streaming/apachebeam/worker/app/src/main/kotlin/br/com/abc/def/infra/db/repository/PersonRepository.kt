package br.com.abc.def.infra.db.repository

import br.com.abc.def.infra.db.schema.Person
import br.com.abc.def.infra.db.schema.QueriesImpl
import java.sql.Connection

class PersonRepository(private val conn: Connection) {
    fun findById(id: Long): Person? {
        return QueriesImpl(this.conn).getPerson(id)
    }
}
