package com.qa.ims

import java.util.Scanner
import java.util.logging.Logger

import com.qa.ims.controllers.{ItemController, OrderController}

object ImsMenu {

  private val LOGGER = Logger.getLogger(ImsMenu.getClass.getSimpleName)

  private val SCANNER = new Scanner(Console.in)
  def getInput(): String ={
    SCANNER.nextLine()
  }

  def menu(): Unit = {
    LOGGER.info("DOMAIN: CUSTOMER, ITEM, ORDER")
    val domain: String = getInput()
    if (domain.equalsIgnoreCase("EXIT")) System.exit(0)
    else
      LOGGER.info(s"What would you like to do with $domain?")
      LOGGER.info("OPERATION: CREATE, READ, UPDATE, DELETE")
      val operation: String = getInput()
      val crud = List("CREATE", "READ", "UPDATE", "DELETE")
      if (crud.contains(operation.toUpperCase()))
        if (domain.equalsIgnoreCase("CUSTOMER")) doAction(CustomerController: Controller, operation)
        if (domain.equalsIgnoreCase("ITEM")) doAction(ItemController: Controller, operation)
        if (domain.equalsIgnoreCase("ORDER")) doAction(OrderController: Controller, operation)
      else LOGGER.warning(s"Invalid input | DOMAIN: $domain, OPERATION: $operation")
    menu()
    }
    def doAction(controller: Controller, operation: String): Unit = {
      if (operation.equalsIgnoreCase("CREATE")) controller.create
      else if (operation.equalsIgnoreCase("READ")) controller.readAll
      else if (operation.equalsIgnoreCase("UPDATE")) controller.update
      else if (operation.equalsIgnoreCase("DELETE")) controller.delete
      else println(s"Invalid --> doAction() $operation")
    }
}
