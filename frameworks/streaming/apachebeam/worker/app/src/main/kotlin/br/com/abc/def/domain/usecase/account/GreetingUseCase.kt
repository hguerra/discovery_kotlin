package br.com.abc.def.domain.usecase.account

class GreetingUseCase {
  operator fun invoke(): String {
    return GreetingWithLogUseCase().greeting()
  }
}
