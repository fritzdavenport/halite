import scala.collection.JavaConversions._

trait HaliteBot {
  val name = ""
  def takeTurn(turn:BigInt, gameMap:GameMap) = Seq.empty[Move]
  def run(args: Array[String]) = {
    val init = Networking.getInit
    val bot  = botMaker.makeBot(init.myID, init.map)
    Networking.sendInit(bot.name)
    (1 to 10000).foreach( turnNum =>
      Networking.sendFrame(
        bot.takeTurn(turnNum, Networking.getFrame)
      )
    )
  }
}

