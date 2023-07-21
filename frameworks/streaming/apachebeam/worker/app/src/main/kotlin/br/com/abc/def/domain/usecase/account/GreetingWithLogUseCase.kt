package br.com.abc.def.domain.usecase.account

import org.slf4j.LoggerFactory

class GreetingWithLogUseCase {
  private val logger = LoggerFactory.getLogger(GreetingWithLogUseCase::class.java)

  fun greeting(): String {
    logger.info("Call greeting...")
    return GREETING
  }
}
