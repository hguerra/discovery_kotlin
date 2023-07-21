package br.com.abc.def.infra.db.repository

import br.com.abc.def.domain.repository.DataSource
import br.com.abc.def.domain.repository.PersonRepository
import br.com.abc.def.infra.db.schema.QueriesImpl

class PersonRepositoryImpl(private val ds: DataSource) : PersonRepository {
  override fun findNameById(id: Long): String? {
    return QueriesImpl(this.ds.connection()).getPerson(id)?.firstName
  }
}
