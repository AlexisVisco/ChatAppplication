package fr.kwizzy.common

import java.awt.TrayIcon.MessageType

/**
  * Par Alexis le 11/12/2016.
  */
class ChatMessage(m: MessageType, message: String) extends Serializable
{

  def getMessage : String = message
  def getType : MessageType = m

  object MessageType extends Enumeration
  {
    type MessageType = Value

    val LOGIN, LOGOUT, MESSAGE, WARNING, ERROR = MessageType
  }
}
