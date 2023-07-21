package br.com.abc.def.infra.db.repository

import br.com.abc.def.domain.repository.DataSource
import com.zaxxer.hikari.HikariDataSource
import java.sql.Connection
import java.sql.SQLException

class DataSourceImpl(private val url: String) : DataSource {
  companion object {
    private const val CONNECTION_TIMEOUT_MILLISECONDS = 30000L
    private const val VALIDATION_TIMEOUT_MILLISECONDS = 5000L
    private const val IDLE_TIMEOUT_MILLISECONDS = 600000L
    private const val POOL_SIZE_MINIMUM_IDLE = 10
    private const val POOL_SIZE_MAXIMUM = 10
  }

  private val dataSource: HikariDataSource by lazy {
    HikariDataSource().apply {
      jdbcUrl = url
      isAutoCommit = false
      connectionTimeout = CONNECTION_TIMEOUT_MILLISECONDS
      validationTimeout = VALIDATION_TIMEOUT_MILLISECONDS
      idleTimeout = IDLE_TIMEOUT_MILLISECONDS
      minimumIdle = POOL_SIZE_MINIMUM_IDLE
      maximumPoolSize = POOL_SIZE_MAXIMUM
    }
  }

  @Throws(SQLException::class)
  override fun connection(): Connection {
    return dataSource.connection
  }
}
