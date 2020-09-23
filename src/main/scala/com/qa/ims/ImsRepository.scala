package com.qa.ims

import reactivemongo.api.bson.collection.BSONCollection
import scala.util.{Failure, Success}
import scala.concurrent.{ExecutionContext, Future}
import reactivemongo.api.{AsyncDriver, Cursor, DB, MongoConnection}
import reactivemongo.api.bson.{BSONDocument, BSONDocumentReader, BSONDocumentWriter, BSONString, Macros, document}

object ImsRepository {
  // My settings (see available connection options)
  val mongoUri = "mongodb://localhost:27017"

  import ExecutionContext.Implicits.global // use any appropriate context

  // Connect to the database
  val driver = AsyncDriver()
  val parsedUri = MongoConnection.fromString(mongoUri)

  // Database and collections: Get references
  val futureConnection = parsedUri.flatMap(driver.connect(_))
  def db1: Future[DB] = futureConnection.flatMap(_.database("scalaimstestdb"))

  def customerCollection: Future[BSONCollection] = db1.map(_.collection("customer"))
  def itemCollection: Future[BSONCollection] = db1.map(_.collection("item"))
  def orderCollection: Future[BSONCollection] = db1.map(_.collection("order"))

  implicit def customerWriter: BSONDocumentWriter[Customer] = Macros.writer[Customer]

  def createCustomer(customer: Customer): Future[Unit] =
    customerCollection.flatMap(_.insert.one(customer).map(_ => {}))

  def updateCustomer(customer: Customer): Future[Int] = {
    val selector = document(
      "forename" -> customer.forename,
      "surname" -> customer.surname
    )
    // Update the matching person
    customerCollection.flatMap(_.update.one(selector, customer).map(_.n))
  }

  implicit def customerReader: BSONDocumentReader[Customer] = Macros.reader[Customer]

  def findCustomerByName(forename: String): Future[List[Customer]] =
    customerCollection.flatMap(_.find(BSONDocument("forename" -> forename)).
      cursor[Customer]().
      collect[List](-1, Cursor.FailOnError[List[Customer]]()))

  def findCustomerById(customer: Customer): Future[List[Customer]] =
    customerCollection.flatMap(_.find(BSONDocument("_id" -> customer._id)). // query builder
      cursor[Customer](). // using the result cursor
      collect[List](-1, Cursor.FailOnError[List[Customer]]()))

    def readAll(): Unit = {
        val customers: Future[List[Customer]] = customerCollection.flatMap(_.find(document())
          .cursor[Customer]()
          .collect[List](-1, Cursor.FailOnError[List[Customer]]()))
        customers andThen {
          case Success(value) => {
            value.foreach(customer => println(customer.toString))
          }
          case Failure(e) => {
            println(e.getMessage.toString)
          }
        }
    }

  def deleteCustomer(forename: String): Unit = {
    val futureRemove = customerCollection.flatMap(_.delete.one(BSONDocument("name" -> forename)))
    futureRemove.onComplete { // callback
      case Failure(e) => throw e
      case Success(writeResult) => println("successfully removed document")
    }
  }

}
//import reactivemongo.api.bson.{BSONDocumentReader, BSONDocumentWriter, Macros}
//import reactivemongo.api.bson.collection.BSONCollection
//import reactivemongo.api.{AsyncDriver, DB, MongoConnection}
//
//import scala.concurrent.Future
//
//object ImsRepository {
//  // get application context
//  import scala.concurrent.ExecutionContext.Implicits.global
//  // connection settings
//  val mongoURI = "mongodb://localhost:27017"
//  // Connect to the db
//  val driver = new AsyncDriver()

//  val parsedURI = MongoConnection.fromString(mongoURI)
//  val connection = parsedURI.flatMap(driver.connect(_))
//  def db: Future[DB] = connection.flatMap(_.database("scalaimsdb"))
//
//  def customerCollection: Future[BSONCollection] = db.map(_.collection("customer"))
//  def itemCollection: Future[BSONCollection] = db.map(_.collection("item"))
//  def orderCollection: Future[BSONCollection] = db.map(_.collection("order"))
//
//  implicit def customerWriter: BSONDocumentWriter[Customer] = Macros.writer[Customer]
//  implicit def customerReader: BSONDocumentReader[Customer] = Macros.reader[Customer]
//
//  implicit def itemWriter: BSONDocumentWriter[Item] = Macros.writer[Item]
//  implicit def itemReader: BSONDocumentReader[Item] = Macros.reader[Item]
//
// implicit def orderWriter: BSONDocumentWriter[Order] = Macros.writer[Order]
// implicit def orderReader: BSONDocumentReader[Order] = Macros.reader[Order]
//}
