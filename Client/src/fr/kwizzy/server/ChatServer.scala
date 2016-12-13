package fr.kwizzy.server

import java.net.{ServerSocket}

class ChatServer(port: Int = 8888) {

  val serverSocket: ServerSocket = new ServerSocket(port)

  def createServer(): Unit = {

    println(s"Attente de connection sur le port: $port")

    var serverT = new ServerThread()

    val thread : Thread = new Thread(serverT)

    thread.start()

    while (true) {
      try {
        var socket = serverSocket.accept()
        serverT.addClient(socket)

        println(s"Connect => n°" + serverT.size)
      } catch {
        case _: Exception => print("")
      }
    }
  }

  def stop() : Unit = {
    serverSocket.close()
    println("Le serveur est en cours d'arrêt.")
  }

}
