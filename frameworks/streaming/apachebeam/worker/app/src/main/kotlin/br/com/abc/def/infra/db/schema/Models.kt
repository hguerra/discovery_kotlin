// Code generated by sqlc. DO NOT EDIT.
// versions:
//   sqlc v1.19.1

package br.com.abc.def.infra.db.schema

data class Person(
  val id: Long,
  val firstName: String,
  val lastName: String,
  val email: String,
)

data class Place(
  val id: Long,
  val country: String,
  val city: String?,
  val telcode: Int,
)

data class Waypoint(
  val id: Long,
  val name: String,
  val geom: Any,
)
