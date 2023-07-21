package br.com.abc.def.domain.other

import br.com.abc.def.domain.GREETING
import org.slf4j.LoggerFactory

class OtherService {
  private val logger = LoggerFactory.getLogger(OtherService::class.java)

  fun greeting(): String {
    logger.info("Call greeting...")
    return GREETING
  }
}
