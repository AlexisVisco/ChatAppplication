package fr.kwizzy.common

/**
  * Par Alexis le 13/12/2016.
  */
trait UnParser[T] {

  def fromData(data:String) : T

}
