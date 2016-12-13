package fr.kwizzy.client

import java.io._
import java.net.Socket
import java.util.Scanner

import fr.kwizzy.common.json.Data

class ChatClient(ip: String = "127.0.0.1", port: Int = 8888, name: String) {

  var socket: Socket = new Socket(ip, port)
  var dos: DataOutputStream = new DataOutputStream(socket.getOutputStream)

  def waitForMessage() : Unit =
  {
    val scanner = new Scanner(System.in)
    while(true)
    {
      if(System.in.available() > 0) {
        val value = scanner.nextLine()
        if(value.equals("exit"))
          return
        val data = new Data().put("name", name).put("message", value).inString()
        sendMessageToServer(data)
      } else if(socket.getInputStream.available > 0) {
        println(new DataInputStream(socket.getInputStream).readUTF())
      } else
        Thread.sleep(10)

    }
  }

  def createConnection() : Unit =
  {
    println(s"Waiting response for $ip:$port...")
    Thread.sleep(100)
    println("Connected!")
    println(s"Your pseudo is: $name")
    println("You can enter a message in the console !")

    waitForMessage()

    socket.close()
    System.exit(1)
  }

  def sendMessageToServer(message: String): Unit =
  {
    dos.writeUTF(message)
    dos.flush()
  }




}
