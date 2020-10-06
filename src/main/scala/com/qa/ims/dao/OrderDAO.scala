package com.qa.ims.dao

import java.util.logging.Logger

//import com.qa.ims.ImsApplication.orderCollection
import com.qa.ims.OrderCase
import reactivemongo.api.Cursor
import reactivemongo.api.bson.document

import scala.concurrent.Future
import scala.util.{Failure, Success}

object OrderDAO extends DAO[OrderCase] {

//  private val LOGGER = Logger.getLogger(OrderDAO.getClass.getSimpleName)
//
//  override def create(order: OrderCase): Unit = {
//    // first _ is an object that is not yet created in memory
//    orderCollection.flatMap(_.insert.one(order).map(_ => {}))
//  }
//
//  override def readAll(): Unit = {
//    val orders: Future[List[OrderCase]] = orderCollection.flatMap(_.find(document())
//      .cursor[OrderCase]()
//      .collect[List](-1, Cursor.FailOnError[List[OrderCase]]()))
//    orders andThen {
//      case Success(value) => {
//        value.foreach(order => LOGGER.info(order.toString))
//      }
//      case Failure(e) => {
//        LOGGER.severe(e.getMessage.toString)
//      }
//    }
//  }
//
//  override def update(t: OrderCase): Unit = ???
//
//  override def delete(t: OrderCase): Unit = ???
  override def create(t: OrderCase): Unit = ???

  override def readAll(): Unit = ???

  override def update(t: OrderCase): Unit = ???

  override def delete(t: OrderCase): Unit = ???
}
