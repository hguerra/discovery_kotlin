package br.com.abc.def.domain.repository

fun interface PersonRepository {
  fun findNameById(id: Long): String?
}
