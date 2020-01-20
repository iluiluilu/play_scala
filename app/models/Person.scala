package models

case class Person(name: String, age: Int)

object Person {
  import play.api.libs.json.Json

  // Generates Writes and Reads for Person, thanks to Json Macros
  implicit val personFormat = Json.format[Person]
}


