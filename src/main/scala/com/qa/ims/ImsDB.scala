package com.qa.ims

import reactivemongo.api.bson.{BSONDocumentReader, BSONDocumentWriter, Macros}
import reactivemongo.api.bson.collection.BSONCollection
import reactivemongo.api.{AsyncDriver, DB, MongoConnection}

import scala.concurrent.Future

object ImsDB {
  // get application context
  import scala.concurrent.ExecutionContext.Implicits.global
  // connection settings
  val mongoURI = "mongodb://localhost:27017"
  // Connect to the db
  val driver = new AsyncDriver()
  val parsedURI = MongoConnection.fromString(mongoURI)
  val connection = parsedURI.flatMap(driver.connect(_))
  def db: Future[DB] = connection.flatMap(_.database("scalaimsdb"))

  def customerCollection: Future[BSONCollection] = db.map(_.collection("customer"))
  def itemCollection: Future[BSONCollection] = db.map(_.collection("item"))
  def orderCollection: Future[BSONCollection] = db.map(_.collection("order"))

  implicit def customerWriter: BSONDocumentWriter[Customer] = Macros.writer[Customer]
  implicit def customerReader: BSONDocumentReader[Customer] = Macros.reader[Customer]

  implicit def itemWriter: BSONDocumentWriter[Item] = Macros.writer[Item]
  implicit def itemReader: BSONDocumentReader[Item] = Macros.reader[Item]

   implicit def orderWriter: BSONDocumentWriter[Order] = Macros.writer[Order]
   implicit def orderReader: BSONDocumentReader[Order] = Macros.reader[Order]
}
