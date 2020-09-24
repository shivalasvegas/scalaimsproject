package com.qa.ims

import reactivemongo.api.bson.BSONString

case class Customer(_id: BSONString, forename: String, surname: String)

