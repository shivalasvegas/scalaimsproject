package com.qa.ims.controllers

import java.util.Scanner
import java.util.logging.Logger

import com.qa.ims.{Customer, DatabaseUser, ImsApplication}
import reactivemongo.api.bson.{BSONObjectID, BSONString}

object CustomerController extends Controller {
  private val LOGGER = Logger.getLogger(CustomerController.getClass.getSimpleName)

  private val SCANNER = new Scanner(Console.in)

  def getInput(): String = {
    SCANNER.nextLine()
  }

  override def create: Unit = {
    println("FORENAME:")
    val forename = getInput()
    println("SURNAME:")
    val surname = getInput()
    //ImsApplication.createCustomer(new CustomerCase(BSONString(BSONObjectID.generate().stringify), forename, surname))
    val newCustomer: DatabaseUser = Customer(BSONString(BSONObjectID.generate().stringify), forename, surname)
    ImsApplication.create(newCustomer)
  }

  override def readAll: Unit = {
    ImsApplication.readAll("customer")
  }

  override def update: Unit = ???

  override def delete: Unit = ???
}
