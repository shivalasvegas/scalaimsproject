package com.qa.ims.dao

import java.util.logging.Logger

//import com.qa.ims.ImsRepository.customerCollection
import com.qa.ims.Customer
import reactivemongo.api.Cursor
import reactivemongo.api.bson.{BSONDocument, BSONString, document}

import scala.concurrent.Future
import scala.util.{Failure, Success}

object CustomerDAO extends DAO[Customer] {

//  private val LOGGER = Logger.getLogger(CustomerDAO.getClass.getSimpleName)
//
//  override def create(customer: Customer): Unit = {
//    // first _ is an object that is not yet created in memory
//    customerCollection.flatMap(_.insert.one(customer).map(_ => {}))
//  }
//
//  override def readAll(): Unit = {
//    val customers: Future[List[Customer]] = customerCollection.flatMap(_.find(document())
//      .cursor[Customer]()
//      .collect[List](-1, Cursor.FailOnError[List[Customer]]()))
//    customers andThen {
//      case Success(value) => {
//        value.foreach(customer => LOGGER.info(customer.toString))
//      }
//      case Failure(e) => {
//        LOGGER.severe(e.getMessage.toString)
//      }
//    }
//  }
//
//  def readById(customer: Customer): Unit = {
//    val id = doc.[BSONString]("_id").get
//    val query = BSONDocument("_id" -> idVal)
//  }
//
//  override def update(customer: Customer): Unit = ???
//
//  override def delete(customer: Customer): Unit = {
//
//    val customers: Future[List[Customer]] = customerCollection.flatMap(_.find(document())
//      .cursor[Customer]()
//      .collect[List](-1, Cursor.FailOnError[List[Customer]]()))
//    customers andThen {
//      case Success(value) => {
//        value.foreach(customer => customerCollection.flatMap(_.delete.one(customer).map(_ => {})))
//      }
//      case Failure(e) => {
//        LOGGER.severe(e.getMessage.toString)
//      }
//    }
//
//  }
  override def create(t: Customer): Unit = ???

  override def readAll(): Unit = ???

  override def update(t: Customer): Unit = ???

  override def delete(t: Customer): Unit = ???
}
