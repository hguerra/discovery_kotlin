package br.com.abc.def.app.web

import br.com.abc.def.domain.other.OtherService

class DummyController {
    fun dummy(): String {
        return OtherService().greeting()
    }
}
