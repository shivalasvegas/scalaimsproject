package com.qa.ims.dao

import java.util.logging.Logger

//import com.qa.ims.ImsApplication.itemCollection
import com.qa.ims.ItemCase
import reactivemongo.api.Cursor
import reactivemongo.api.bson.document

import scala.concurrent.Future
import scala.util.{Failure, Success}

object ItemDAO extends DAO[ItemCase] {

//  private val LOGGER = Logger.getLogger(ItemDAO.getClass.getSimpleName)
//
//  override def create(item: ItemCase): Unit = {
//    // first _ is an object that is not yet created in memory
//    itemCollection.flatMap(_.insert.one(item).map(_ => {}))
//  }
//
//  override def readAll(): Unit = {
//    val items: Future[List[ItemCase]] = itemCollection.flatMap(_.find(document())
//      .cursor[ItemCase]()
//      .collect[List](-1, Cursor.FailOnError[List[ItemCase]]()))
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
//  override def update(t: ItemCase): Unit = ???
//
//  override def delete(t: ItemCase): Unit = ???
  override def create(t: ItemCase): Unit = ???

  override def readAll(): Unit = ???

  override def update(t: ItemCase): Unit = ???

  override def delete(t: ItemCase): Unit = ???
}
