package com.qa.ims

import java.util.Scanner
import java.util.logging.Logger

import reactivemongo.api.bson.{BSONObjectID, BSONString}

object CustomerController extends Controller {
  private val LOGGER = Logger.getLogger(CustomerController.getClass.getSimpleName)

  private val SCANNER = new Scanner(Console.in)

  def getInput(): String ={
    SCANNER.nextLine()
  }
  override def create: Unit = {
    LOGGER.info("FORENAME:")
    val forename = getInput()
    LOGGER.info("SURNAME:")
    val surname = getInput()
    CustomerDAO.create(new Customer(BSONString(BSONObjectID.generate().stringify), forename, surname))
  }

  override def readAll: Unit = {
    CustomerDAO.readAll()
  }

  override def update: Unit = ???

  override def delete: Unit = ???
}
