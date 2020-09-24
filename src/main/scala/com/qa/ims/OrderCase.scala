package com.qa.ims

import reactivemongo.api.bson.BSONString

case class OrderCase(_id: BSONString, item: String, price: String)

