package com.qa.ims

import java.util.Scanner
import java.util.logging.Logger

//import com.qa.ims.dao.CustomerDAO
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
    ImsRepository.createCustomer(new Customer(BSONString(BSONObjectID.generate().stringify), forename, surname))
  }

  override def readAll: Unit = {
    ImsRepository.readAll()
  }

  override def update: Unit = {
    LOGGER.info("FORENAME:")
    val forename = getInput()
    LOGGER.info("SURNAME:")
    val surname = getInput()
    ImsRepository.updateCustomer(new Customer(_, forename, surname))
  }

  override def delete: Unit = {
    LOGGER.info("FORENAME:")
    val forename = getInput()

    ImsRepository.deleteCustomer(forename)
  }
}
