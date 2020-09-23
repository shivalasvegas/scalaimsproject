package com.qa.ims

import java.util.logging.Logger

import com.qa.ims.ImsDB.{customerCollection, customerReader, customerWriter}
import reactivemongo.api.Cursor
import reactivemongo.api.bson.document

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object CustomerDAO extends DAO[Customer]{

  private val LOGGER = Logger.getLogger(CustomerDAO.getClass.getSimpleName)
  override def create(customer: Customer): Unit = {
    // first _ is an object that is not yet created in memory
    customerCollection.flatMap(_.insert.one(customer).map(_ => { }))
  }
  override def readAll(): Unit = {
    val customers: Future[List[Customer]] = customerCollection.flatMap(_.find(document())
      .cursor[Customer]()
      .collect[List](-1, Cursor.FailOnError[List[Customer]]()))
    customers andThen {
      case Success(value) => {
        value.foreach(customer => LOGGER.info(customer.toString))
      }
      case Failure(e) => {
        LOGGER.severe(e.getMessage.toString)
      }
    }
  }

  override def update(t: Customer): Unit = ???

  override def delete(id: String): Unit = ???
}
