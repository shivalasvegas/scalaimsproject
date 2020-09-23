package com.qa.ims.dao

trait DAO[T] {
  def create(t: T)

  def readAll()

  def update(t: T)

  def delete(t: T)
}
