package com.qa.ims

import reactivemongo.api.bson.BSONString
sealed class DatabaseUser

case class Customer(_id: BSONString, forename: String, surname: String) extends DatabaseUser
case class Item(_id: BSONString, itemName: String, price: String) extends DatabaseUser
case class Product(_id: BSONString, customerName: String, itemName: String, price: String) extends DatabaseUser
