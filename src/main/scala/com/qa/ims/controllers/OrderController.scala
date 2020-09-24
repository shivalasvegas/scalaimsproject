package com.qa.ims.controllers

import java.util.Scanner
import java.util.logging.Logger

import com.qa.ims.dao.OrderDAO
import com.qa.ims.{Controller, OrderCase}
import reactivemongo.api.bson.{BSONObjectID, BSONString}

object OrderController extends Controller{
  private val LOGGER = Logger.getLogger(OrderController.getClass.getSimpleName)

  private val SCANNER = new Scanner(Console.in)

  def getInput(): String ={
    SCANNER.nextLine()
  }
  override def create: Unit = {
    LOGGER.info("ITEM:")
    val item = getInput()
    LOGGER.info("PRICE:")
    val price = getInput()
    OrderDAO.create(new OrderCase(BSONString(BSONObjectID.generate().stringify), item, price))
  }

  override def readAll: Unit = {
    OrderDAO.readAll()
  }

  override def update: Unit = ???

  override def delete: Unit = ???
}
