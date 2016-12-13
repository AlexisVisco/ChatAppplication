package fr.kwizzy.server

import java.util.Scanner

import fr.kwizzy.server.command.{CommandCreator, Commands}

/**
  * Par Alexis le 11/12/2016.
  */

object AppServer {

  var chatServer : ChatServer = new ChatServer

  def main(main: Array[String]): Unit = {

    Commands.register()

    createServer(9999)
    waitEntries()

  }

  def createServer(implicit port: Int = 8888) : Unit = {
    println(s"Démarrage d'un serveur sur le port $port.")
    chatServer = new ChatServer(port)
    chatServer.createServer()
    waitEntries()
  }

  def waitEntries() : Unit =
  {
    val scan = new Scanner(System.in)
    while(scan.hasNext)
    {
      val str = scan.nextLine()
      println("Entered " + str)
      CommandCreator.execute(str)      
    }
  }
}

