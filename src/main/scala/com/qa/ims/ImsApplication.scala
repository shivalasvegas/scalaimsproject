package com.qa.ims

import reactivemongo.api.bson.collection.BSONCollection
import scala.util.{Failure, Success}
import scala.concurrent.{ExecutionContext, Future}
import reactivemongo.api.{AsyncDriver, Cursor, DB, MongoConnection}
import reactivemongo.api.bson.{BSONDocument, BSONDocumentReader, BSONDocumentWriter, BSONString, Macros, document}

object ImsApplication {

  val mongoUri = "mongodb://localhost:27017"

  import ExecutionContext.Implicits.global

  // Connect to the database
  val driver = AsyncDriver()
  val parsedUri = MongoConnection.fromString(mongoUri)

  // Database and collections
  val futureConnection = parsedUri.flatMap(driver.connect(_))
  def db1: Future[DB] = futureConnection.flatMap(_.database("scalaimstestdb"))

  def customerCollection: Future[BSONCollection] = db1.map(_.collection("customer"))
  def itemCollection: Future[BSONCollection] = db1.map(_.collection("item"))
  def orderCollection: Future[BSONCollection] = db1.map(_.collection("order"))

  implicit def customerWriter: BSONDocumentWriter[Customer] = Macros.writer[Customer]
  implicit def itemWriter: BSONDocumentWriter[Item] = Macros.writer[Item]
  implicit def orderWriter: BSONDocumentWriter[Order] = Macros.writer[Order]
  implicit def databaseWriter: BSONDocumentWriter[DatabaseUser] = Macros.writer[DatabaseUser]
  implicit def customerReader: BSONDocumentReader[Customer] = Macros.reader[Customer]
  implicit def itemReader: BSONDocumentReader[Item] = Macros.reader[Item]
  implicit def orderReader: BSONDocumentReader[Order] = Macros.reader[Order]
  implicit def databaseReader: BSONDocumentReader[DatabaseUser] = Macros.reader[DatabaseUser]

  def create(databaseUser: DatabaseUser): Future[Unit] = {
    databaseUser match {
      case a: Customer => customerCollection.flatMap(_.insert.one(databaseUser).map(_ => {}))
      case b: Item => itemCollection.flatMap(_.insert.one(databaseUser).map(_ => {}))
      case c: Order => orderCollection.flatMap(_.insert.one(databaseUser).map(_ => {}))
    }
  }

  def readAll(user: String): Unit = {
      user match {
        case "customer" => readAllUsers(customerCollection)
        case "item" => readAllUsers(itemCollection)
        case "order" => readAllUsers(orderCollection)
      }
  }

  def readAllUsers(collection: Future[BSONCollection]): Unit = {
      val userList: Future[List[DatabaseUser]] = collection.flatMap(_.find(document())
        .cursor[DatabaseUser]()
        .collect[List](-1, Cursor.FailOnError[List[DatabaseUser]]()))
      userList andThen {
        case Success(value) => {
          value.foreach(databaseUser => println(databaseUser.toString))
        }
        case Failure(e) => {
          println(e.getMessage.toString)
        }
      }
    }

}
