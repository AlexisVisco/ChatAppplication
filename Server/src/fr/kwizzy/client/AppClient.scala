package fr.kwizzy.client

import fr.kwizzy.common.GeneratorPseudo


/**
  * Par Alexis le 11/12/2016.
  */
object AppClient {

  var chatClient : ChatClient = _

  def main(main: Array[String]): Unit =
  {
    chatClient = new ChatClient(name = new GeneratorPseudo().generate(2), port = 9999)
    chatClient.createConnection()
  }

}
