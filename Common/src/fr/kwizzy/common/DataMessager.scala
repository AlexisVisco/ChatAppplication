package fr.kwizzy.common


import fr.kwizzy.common.json.Data

/**
  * Par Alexis le 13/12/2016.
  */

case class DataMessager(name: String, message: String){

}

object DataMessager extends UnParser[DataMessager]{

  override def fromData(data: String): DataMessager = {
    val d = new Data(data)
    new DataMessager(d.getString("name"), d.getString("message"))
  }
}

