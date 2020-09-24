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
    //ImsRepository.createCustomer(new CustomerCase(BSONString(BSONObjectID.generate().stringify), forename, surname))
    val newCustomer: DatabaseUser = Customer(BSONString(BSONObjectID.generate().stringify), forename, surname)
    ImsRepository.create(newCustomer)
  }

  override def readAll: Unit = {
    ImsRepository.readAll()
  }

  override def update: Unit = ???

  override def delete: Unit = ???
}
