package com.qa.ims

import reactivemongo.api.bson.BSONString

case class Order(_id: BSONString, item: String, price: String)

