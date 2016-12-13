package fr.kwizzy.server.command

import fr.kwizzy.server.{AppServer, ChatServer}

/**
  * Par Alexis le 11/12/2016.
  */
object Commands {

  def register() : Unit = {
    CommandCreator.put(
      new CommandStop,
      new CommandChangePort
    )
  }

}

class CommandStop extends CommandCreator("stop"){

  override def command(str: Array[String]): Unit = {
    AppServer.chatServer.stop()
    System.exit(1)
  }

}

class CommandChangePort extends CommandCreator("onport"){
  override def command(str: Array[String]): Unit = {
    if(!(str.length >= 2 && isNumber(str(1))))
      return
    val port = Integer.parseInt(str(1))
    print("Changement de port, redémarrage du serveur...")
    AppServer.chatServer.stop()
    AppServer.createServer(port)
  }
}