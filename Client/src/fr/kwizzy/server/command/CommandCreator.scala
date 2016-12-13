package fr.kwizzy.server.command


/**
  * Par Alexis le 11/12/2016.
  */
abstract class CommandCreator(name: String) {

  def command(str: Array[String])

  def getName: String = name

  def isNumber(x: String): Boolean = x forall Character.isDigit

}

object CommandCreator {

  var commands: List[CommandCreator] = List()

  def put(command: CommandCreator*): Unit = command.foreach(e => commands = e :: commands)

  def execute(name: String): Unit = {
    commands.filter(_.getName.equalsIgnoreCase(name.split(" ")(0)))
      .foreach(e => e.command(name.split(" ")))
  }
}
