package controllers

import javax.inject.Inject
import models.Person
import play.api.mvc.{AbstractController, ControllerComponents}
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.play.json._, collection._

import scala.concurrent.{ExecutionContext, Future}

class MongoSampleController @Inject()(cc: ControllerComponents, val reactiveMongoApi: ReactiveMongoApi) extends AbstractController(cc)
  with MongoController with ReactiveMongoComponents {

  implicit def ec: ExecutionContext = cc.executionContext

  def collection: Future[JSONCollection] = database.map(
    _.collection[JSONCollection]("persons"))

  def index = Action {
    collection.flatMap(_.insert.one(Person("abc", (math.random()*100).toInt))).map { lastError =>
      Created
    }
    Ok(views.html.index("Your new application is ready."))
  }
}
