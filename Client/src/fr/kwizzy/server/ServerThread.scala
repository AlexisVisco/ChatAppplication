package fr.kwizzy.server

import java.io.{DataInputStream, DataOutputStream, InputStream}
import java.net.Socket

import fr.kwizzy.common.DataMessager

import scala.collection.mutable.ListBuffer


/**
  * Par Alexis le 11/12/2016.
  */
class ServerThread() extends Runnable {

  var clients: ListBuffer[Socket] = new ListBuffer

  override def run(): Unit = {

    while (true) {
      try {
        clients.foreach { e =>
          if (!e.isConnected)
            clients -= e
          else {
            val in = e.getInputStream
            if (in.available() > 0)
              readPacket(in)
          }
        }
        Thread.sleep(10);
      } catch {
        case _: Exception => print("")
      }
    }
  }

  def addClient(socket: Socket): Unit = clients += socket

  def size: Int = clients.size

  def readPacket(in: InputStream): Unit = {
    val din = new DataInputStream(in)
    val dataMessager = DataMessager.fromData(din.readUTF())
    broadcast(dataMessager.name + " say: " + dataMessager.message)
  }

  def broadcast(message: String): Unit = {
    clients.foreach { e =>
      if (!e.isConnected)
        clients -= e
      else {
        try {
          val dos = new DataOutputStream(e.getOutputStream)
          dos.writeUTF(message)
          dos.flush()
        } catch {
          case _: Exception => clients -= e
        }
      }
    }
  }

}
