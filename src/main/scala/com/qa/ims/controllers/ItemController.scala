package com.qa.ims.controllers

import java.util.Scanner
import java.util.logging.Logger

import com.qa.ims.dao.ItemDAO
import com.qa.ims.ItemCase
import reactivemongo.api.bson.{BSONObjectID, BSONString}

object ItemController extends Controller {
  private val LOGGER = Logger.getLogger(ItemController.getClass.getSimpleName)

  private val SCANNER = new Scanner(Console.in)

  def getInput(): String ={
    SCANNER.nextLine()
  }
  override def create: Unit = {
    LOGGER.info("ITEM:")
    val item = getInput()
    LOGGER.info("PRICE:")
    val price = getInput()
    ItemDAO.create(new ItemCase(BSONString(BSONObjectID.generate().stringify), item, price))
  }

  override def readAll: Unit = {
    ItemDAO.readAll()
  }

  override def update: Unit = ???

  override def delete: Unit = ???
  }
