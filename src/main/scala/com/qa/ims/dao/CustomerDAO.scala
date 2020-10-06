package com.qa.ims.dao

import java.util.logging.Logger

//import com.qa.ims.ImsApplication.customerCollection
import com.qa.ims.CustomerCase
import reactivemongo.api.Cursor
import reactivemongo.api.bson.{BSONDocument, BSONString, document}

import scala.concurrent.Future
import scala.util.{Failure, Success}

object CustomerDAO extends DAO[CustomerCase] {

//  private val LOGGER = Logger.getLogger(CustomerDAO.getClass.getSimpleName)
//
//  override def create(customer: CustomerCase): Unit = {
//    // first _ is an object that is not yet created in memory
//    customerCollection.flatMap(_.insert.one(customer).map(_ => {}))
//  }
//
//  override def readAll(): Unit = {
//    val customers: Future[List[CustomerCase]] = customerCollection.flatMap(_.find(document())
//      .cursor[CustomerCase]()
//      .collect[List](-1, Cursor.FailOnError[List[CustomerCase]]()))
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
//  def readById(customer: CustomerCase): Unit = {
//    val id = doc.[BSONString]("_id").get
//    val query = BSONDocument("_id" -> idVal)
//  }
//
//  override def update(customer: CustomerCase): Unit = ???
//
//  override def delete(customer: CustomerCase): Unit = {
//
//    val customers: Future[List[CustomerCase]] = customerCollection.flatMap(_.find(document())
//      .cursor[CustomerCase]()
//      .collect[List](-1, Cursor.FailOnError[List[CustomerCase]]()))
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
  override def create(t: CustomerCase): Unit = ???

  override def readAll(): Unit = ???

  override def update(t: CustomerCase): Unit = ???

  override def delete(t: CustomerCase): Unit = ???
}
