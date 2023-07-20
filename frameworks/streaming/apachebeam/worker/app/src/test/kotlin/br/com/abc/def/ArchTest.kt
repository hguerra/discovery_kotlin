package br.com.abc.def

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.Test

/**
 * Projetar um microsserviço orientado a DDD:
 * https://docs.microsoft.com/pt-br/dotnet/architecture/microservices/microservice-ddd-cqrs-patterns/ddd-oriented-microservice
 * https://gist.github.com/gdouglas7/b29c661c6f43ef3098777db4dcd1d6ee#file-arquiteturatest-kt
 * https://github.com/spanierm42/archunit-junit5-kotlin/blob/master/src/test/kotlin/com/github/spanierm/archunitjunit5kotlin/onion/OnionArchitectureTest.kt
 * https://www.archunit.org/userguide/html/000_Index.html#_using_junit_4_or_junit_5
 * https://github.com/TNG/ArchUnit-Examples/blob/main/example-junit5/src/test/java/com/tngtech/archunit/exampletest/junit5/LayerDependencyRulesTest.java
 *
 * Regras:
 * 1) A camada de dominio (regras de negocio) nao deve depender de outras camadas;
 * 2) A camada de infraestrutura "pode" depender APENAS da camada de dominio;
 */
class ArchTest {
  private val basePackage = "br.com.abc.def"

  private val importedClasses =
    ClassFileImporter()
      .withImportOption(
        ImportOption.Predefined.DO_NOT_INCLUDE_TESTS,
      )
      .importPackages(basePackage)

  @Test
  fun `a camada de dominio nao deve depender de outras camadas`() {
    noClasses()
      .that()
      .resideInAnyPackage("$basePackage.domain..")
      .should()
      .dependOnClassesThat()
      .resideInAnyPackage("$basePackage.infra..", "$basePackage.app..")
      .check(importedClasses)
  }

  @Test
  fun `a camada de infraestrutura pode depender apenas da camada de dominio`() {
    noClasses()
      .that()
      .resideInAnyPackage("$basePackage.infra..")
      .should()
      .dependOnClassesThat()
      .resideInAnyPackage("$basePackage.app..")
      .check(importedClasses)
  }
}
