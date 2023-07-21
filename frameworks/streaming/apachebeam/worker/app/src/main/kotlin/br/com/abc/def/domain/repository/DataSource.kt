package br.com.abc.def.domain.repository

import java.sql.Connection
import java.sql.SQLException

fun interface DataSource {
  @Throws(SQLException::class) fun connection(): Connection
}
