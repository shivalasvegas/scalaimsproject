package com.qa.ims

import reactivemongo.api.bson.BSONString

case class ItemCase(_id: BSONString, item: String, price: String)
