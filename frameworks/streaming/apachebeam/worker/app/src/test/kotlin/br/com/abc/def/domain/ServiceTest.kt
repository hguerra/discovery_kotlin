package br.com.abc.def.domain

import br.com.abc.def.App
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class ServiceTest {
    @Test
    fun `should have a greeting`() {
        val classUnderTest = App()
        classUnderTest.greeting shouldBe "Hello World!"
    }

    @Test
    fun `mockk should be configured`() {
        val mockClass = mockk<App>()
        every { mockClass.greeting } returns "Works!"
        mockClass.greeting shouldBe "Works!"
    }
}
