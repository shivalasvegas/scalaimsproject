package com.qa.ims

import reactivemongo.api.bson.collection.BSONCollection
import scala.util.{Failure, Success}
import scala.concurrent.{ExecutionContext, Future}
import reactivemongo.api.{AsyncDriver, Cursor, DB, MongoConnection}
import reactivemongo.api.bson.{BSONDocument, BSONDocumentReader, BSONDocumentWriter, BSONString, Macros, document}

object ImsRepository {

  val mongoUri = "mongodb://localhost:27017"

  import ExecutionContext.Implicits.global

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
  implicit def itemWriter: BSONDocumentWriter[Item] = Macros.writer[Item]
  implicit def orderWriter: BSONDocumentWriter[Order] = Macros.writer[Order]
  implicit def databaseWriter: BSONDocumentWriter[DatabaseUser] = Macros.writer[DatabaseUser]
  implicit def customerReader: BSONDocumentReader[Customer] = Macros.reader[Customer]
  implicit def itemReader: BSONDocumentReader[Item] = Macros.reader[Item]
  implicit def orderReader: BSONDocumentReader[Order] = Macros.reader[Order]
  implicit def databaseReader: BSONDocumentReader[DatabaseUser] = Macros.reader[DatabaseUser]

//  def createCustomer(customer: CustomerCase): Future[Unit] =
//    customerCollection.flatMap(_.insert.one(customer).map(_ => {}))

  def create(databaseUser: DatabaseUser): Future[Unit] = {
    databaseUser match {
      case a: Customer => customerCollection.flatMap(_.insert.one(databaseUser).map(_ => {}))
      case b: Item => itemCollection.flatMap(_.insert.one(databaseUser).map(_ => {}))
      case c: Order => orderCollection.flatMap(_.insert.one(databaseUser).map(_ => {}))
    }

  }

  // specific customer queries
//  def findCustomerByName(forename: String): Future[List[CustomerCase]] =
//    customerCollection.flatMap(_.find(BSONDocument("forename" -> forename)).
//      cursor[CustomerCase]().
//      collect[List](-1, Cursor.FailOnError[List[CustomerCase]]()))
//
//  def findCustomerById(customer: CustomerCase): Future[List[CustomerCase]] =
//    customerCollection.flatMap(_.find(BSONDocument("_id" -> customer._id)). // query builder
//      cursor[CustomerCase](). // using the result cursor
//      collect[List](-1, Cursor.FailOnError[List[CustomerCase]]()))

    def readAll(user: String): Unit = {
        user match {
          case "customer" => readAllCustomers()
          case "item" => readAllItems()
          case "order" => readAllOrders()
        }
        }
//      def readAllUsers(): Unit = {
//        val customers: Future[List[CustomerCase]] = customerCollection.flatMap(_.find(document())
//          .cursor[CustomerCase]()
//          .collect[List](-1, Cursor.FailOnError[List[CustomerCase]]()))
//        customers andThen {
//          case Success(value) => {
//            value.foreach(customer => println(customer.toString))
//          }
//          case Failure(e) => {
//            println(e.getMessage.toString)
//          }
//        }
//      }

        def readAllCustomers(): Unit = {
          val customers: Future[List[DatabaseUser]] = customerCollection.flatMap(_.find(document())
            .cursor[DatabaseUser]()
            .collect[List](-1, Cursor.FailOnError[List[DatabaseUser]]()))
          customers andThen {
            case Success(value) => {
              value.foreach(customer => println(customer.toString))
            }
            case Failure(e) => {
              println(e.getMessage.toString)
            }
          }
        }

  def readAllItems(): Unit = {
    val items: Future[List[DatabaseUser]] = itemCollection.flatMap(_.find(document())
      .cursor[DatabaseUser]()
      .collect[List](-1, Cursor.FailOnError[List[DatabaseUser]]()))
    items andThen {
      case Success(value) => {
        value.foreach(item => println(item.toString))
      }
      case Failure(e) => {
        println(e.getMessage.toString)
      }
    }
  }
  def readAllOrders(): Unit = {
    val orders: Future[List[DatabaseUser]] = orderCollection.flatMap(_.find(document())
      .cursor[DatabaseUser]()
      .collect[List](-1, Cursor.FailOnError[List[DatabaseUser]]()))
    orders andThen {
      case Success(value) => {
        value.foreach(order => println(order.toString))
      }
      case Failure(e) => {
        println(e.getMessage.toString)
      }
    }
  }



}
