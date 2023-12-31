/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package br.com.abc.def

import br.com.abc.def.app.web.DummyController
import org.apache.beam.sdk.Pipeline
import org.apache.beam.sdk.options.Default
import org.apache.beam.sdk.options.Description
import org.apache.beam.sdk.options.PipelineOptions
import org.apache.beam.sdk.options.PipelineOptionsFactory
import org.apache.beam.sdk.transforms.Create
import org.apache.beam.sdk.transforms.MapElements
import org.apache.beam.sdk.transforms.SimpleFunction
import org.apache.beam.sdk.values.PCollection
import org.slf4j.LoggerFactory

interface Options : PipelineOptions {
  @get:Description("Input text to print.")
  @get:Default.String("My input text")
  var inputText: String
}

class PrintElement : SimpleFunction<String, String>() {
  override fun apply(element: String): String {
    println(element)
    return element
  }
}

fun buildPipeline(pipeline: Pipeline, inputText: String): PCollection<String> =
    pipeline
        .apply("Create elements", Create.of("Hello", "World!", inputText))
        .apply("Print elements", MapElements.via(PrintElement()))

fun main(args: Array<String>) {
  val logger = LoggerFactory.getLogger(DummyController::class.java)
  logger.info(
    "Java System Property '-Dlogback.configurationFile=${System.getProperty("logback.configurationFile")}'"
  )

  val options = PipelineOptionsFactory.fromArgs(*args).withValidation().`as`(Options::class.java)
  val pipeline = Pipeline.create(options)
  buildPipeline(pipeline, options.inputText)
  pipeline.run().waitUntilFinish()
}
