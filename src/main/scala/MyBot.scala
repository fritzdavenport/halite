import scala.collection.JavaConversions._

class MyBot(id: Int, gameMap:GameMap) extends HaliteBot(id, gameMap) {

  override def takeTurn(turn:BigInt, gameMap:GameMap): Seq[Move] = {
    // Random moves
    val moves = Seq.empty[Move]
    for (y <- 0 to gameMap.height - 1) {
      for (x <- 0 to gameMap.width - 1) {
        val site: Site = gameMap.getSite(new Location(x, y))
        if (site.owner == id) {
          val dir: Direction = Direction.randomDirection
          moves.add(new Move(new Location(x, y), dir))
        }
      }
    }
    moves
  }
}

object MyBot extends App {
  new MyBot()
}