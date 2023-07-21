package br.com.abc.def.domain.usecase.account

import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class GreetingWithLogUseCaseTest {
  @Test
  fun `mockk should be configured`() {
    val mockClass = mockk<GreetingWithLogUseCase>()
    every { mockClass.greeting() } returns "Works!"
    mockClass.greeting() shouldBe "Works!"
  }
}
