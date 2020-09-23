package com.qa.ims

import reactivemongo.api.bson.BSONString

case class Item(_id: BSONString, item: String, price: String)
