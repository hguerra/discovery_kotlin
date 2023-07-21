package br.com.abc.def.domain.usecase.account

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class GreetingUseCaseTest {
  @Test
  fun `should have a greeting`() {
    val greetingUseCase = GreetingUseCase()
    greetingUseCase() shouldBe "Hello World!"
  }
}
