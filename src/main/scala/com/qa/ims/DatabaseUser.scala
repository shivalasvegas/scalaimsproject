package com.qa.ims

import reactivemongo.api.bson.BSONString

sealed trait DatabaseUser

case class Customer(_id: BSONString, forename: String, surname: String) extends DatabaseUser
case class Item(_id: BSONString, itemName: String, price: String) extends DatabaseUser
case class Order(_id: BSONString, customerName: String, itemName: String, price: String) extends DatabaseUser

