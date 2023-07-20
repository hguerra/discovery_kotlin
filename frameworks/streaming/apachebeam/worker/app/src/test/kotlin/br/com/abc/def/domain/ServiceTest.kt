package br.com.abc.def.domain

import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class ServiceTest {
    @Test
    fun `should have a greeting`() {
        val classUnderTest = Service()
        classUnderTest.greeting shouldBe "Hello World!"
    }

    @Test
    fun `mockk should be configured`() {
        val mockClass = mockk<Service>()
        every { mockClass.greeting } returns "Works!"
        mockClass.greeting shouldBe "Works!"
    }
}
