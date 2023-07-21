package br.com.abc.def.app.web

import br.com.abc.def.domain.repository.DataSource
import br.com.abc.def.domain.repository.PersonRepository
import br.com.abc.def.domain.usecase.account.GreetingUseCase
import br.com.abc.def.infra.db.repository.DataSourceImpl
import br.com.abc.def.infra.db.repository.PersonRepositoryImpl
import java.sql.DriverManager
import org.slf4j.LoggerFactory

class DummyController {
  private val logger = LoggerFactory.getLogger(DummyController::class.java)

  fun perform() {
    logger.info("Starting...")

    logger.info(GreetingUseCase()())
    logger.info(
        "Java System Property '-Dlogback.configurationFile=${System.getProperty("logback.configurationFile")}'")

    val connection1 = DriverManager.getConnection(System.getenv("JDBC_DATABASE_URL"))
    logger.info("isValid connection DriverManager: ${connection1.isValid(0)}")

    val dataSource: DataSource = DataSourceImpl(System.getenv("JDBC_DATABASE_URL"))
    val connection2 = dataSource.connection()
    logger.info("isValid connection HikariDataSource: ${connection2.isValid(0)}")

    val repo: PersonRepository = PersonRepositoryImpl(dataSource)
    logger.info("Person found ${repo.findNameById(1L)}")
  }
}
