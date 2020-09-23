package com.qa.ims

import java.util.logging.Logger

import com.qa.ims.ImsDB.{orderCollection, orderReader, orderWriter}
import reactivemongo.api.Cursor
import reactivemongo.api.bson.document

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object OrderDAO extends DAO[Order] {

  private val LOGGER = Logger.getLogger(OrderDAO.getClass.getSimpleName)
  override def create(order: Order): Unit = {
    // first _ is an object that is not yet created in memory
    orderCollection.flatMap(_.insert.one(order).map(_ => { }))
  }
  override def readAll(): Unit = {
    val orders: Future[List[Order]] = orderCollection.flatMap(_.find(document())
      .cursor[Order]()
      .collect[List](-1, Cursor.FailOnError[List[Order]]()))
    orders andThen {
      case Success(value) => {
        value.foreach(order => LOGGER.info(order.toString))
      }
      case Failure(e) => {
        LOGGER.severe(e.getMessage.toString)
      }
    }
  }

  override def update(t: Order): Unit = ???

  override def delete(t: Order): Unit = ???
}
