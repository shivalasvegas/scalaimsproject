package com.qa.ims.dao

import java.util.logging.Logger

//import com.qa.ims.ImsRepository.itemCollection
import com.qa.ims.Item
import reactivemongo.api.Cursor
import reactivemongo.api.bson.document

import scala.concurrent.Future
import scala.util.{Failure, Success}

object ItemDAO extends DAO[Item] {

//  private val LOGGER = Logger.getLogger(ItemDAO.getClass.getSimpleName)
//
//  override def create(item: Item): Unit = {
//    // first _ is an object that is not yet created in memory
//    itemCollection.flatMap(_.insert.one(item).map(_ => {}))
//  }
//
//  override def readAll(): Unit = {
//    val items: Future[List[Item]] = itemCollection.flatMap(_.find(document())
//      .cursor[Item]()
//      .collect[List](-1, Cursor.FailOnError[List[Item]]()))
//    items andThen {
//      case Success(value) => {
//        value.foreach(item => LOGGER.info(item.toString))
//      }
//      case Failure(e) => {
//        LOGGER.severe(e.getMessage.toString)
//      }
//    }
//  }
//
//  override def update(t: Item): Unit = ???
//
//  override def delete(t: Item): Unit = ???
  override def create(t: Item): Unit = ???

  override def readAll(): Unit = ???

  override def update(t: Item): Unit = ???

  override def delete(t: Item): Unit = ???
}
