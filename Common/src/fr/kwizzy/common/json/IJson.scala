package fr.kwizzy.common.json

import scala.collection.mutable.ListBuffer

/**
  * Par Alexis le 13/12/2016.
  * From Hexagonal pattern test
  */
trait IJson {

  def get(key: String) : Object
  def getString(key: String) : String
  def getInt(key: String) : Int
  def getDouble(key: String) : Double
  def getBoolean(key: String) : Boolean
  def remove(key: String)
  def put(key: String, value: Object) : IJson
  def inString() : String

}
