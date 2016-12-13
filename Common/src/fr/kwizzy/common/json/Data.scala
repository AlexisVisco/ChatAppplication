package fr.kwizzy.common.json

import org.json.JSONObject

import scala.collection.mutable.ListBuffer

/**
  * Par Alexis le 13/12/2016.
  *
  * Implement a json abstraction like a hexagonal pattern
  */
class Data(source: String = "{}") extends IJson{

  val json : JSONObject = new JSONObject(source)

  override def remove(key: String): Unit = json.remove(key)

  override def get(key: String): Object = json.get(key)

  override def getString(key: String): String = json.getString(key)

  override def getInt(key: String): Int = json.getInt(key)

  override def getDouble(key: String): Double = json.getDouble(key)

  override def getBoolean(key: String): Boolean = json.getBoolean(key)

  override def put(key: String, value: Object): IJson = {
    json.put(key, value)
    this
  }

  override def inString(): String = json.toString()
}
