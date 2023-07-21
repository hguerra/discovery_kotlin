package br.com.abc.def.domain

import br.com.abc.def.domain.other.OtherService

class Service {
    val greeting: String
        get() {
            return OtherService().greeting()
        }
}
