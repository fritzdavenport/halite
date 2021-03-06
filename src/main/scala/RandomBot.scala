import scala.collection.mutable

/**
  * Created by snoe on 7/23/16.
  */
class RandomBot(id: Int, gameMap:GameMap) extends HaliteBot(id, gameMap) {

  override def takeTurn(turn:BigInt, gameMap:GameMap) = {
    // Random moves
    val moves = mutable.Seq.empty[Move]
    for (y <- 0 to gameMap.height - 1) {
      for (x <- 0 to gameMap.width - 1) {
        if (gameMap.getSite(new Location(x, y)).owner == id) {
          moves :+ new Move(new Location(x, y), Direction.randomDirection)
        }
      }
    }
    moves
  }

}

object RandomBot {

  def main(args:Array[String]):Unit = {

    val maker = new HaliteBotMaker() {
      override def makeBot(id:Int, gameMap:GameMap):HaliteBot = new RandomBot(id, gameMap)
    }

    HaliteBot.run(args, maker)
  }
}
