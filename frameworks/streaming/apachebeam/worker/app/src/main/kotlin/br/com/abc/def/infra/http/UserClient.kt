package br.com.abc.def.infra.http

import br.com.abc.def.domain.User

class UserClient {
    fun user(): User {
        return User(1L, "Heitor")
    }
}
