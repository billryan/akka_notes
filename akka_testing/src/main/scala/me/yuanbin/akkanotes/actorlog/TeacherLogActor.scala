package me.yuanbin.akkanotes.actorlog

import akka.actor.Actor
import akka.actor.ActorLogging
import me.yuanbin.akkanotes.protocols.TeacherProtocol._
import me.yuanbin.akkanotes.protocols.StudentProtocol._
import scala.util.Random

/**
 * Teacher with Logging
 *
 */
class TeacherLogActor extends Actor with ActorLogging {
  val quotes = List(
    "Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is you think you have time",
    "You never gonna know if you never even try")

  def receive = {
    case QuoteRequest => {
      //get a random element (for now)
      val quoteResponse = QuoteResponse(quotes(Random.nextInt(quotes.size)))
      log.info(quoteResponse.toString())

      //log.info("Quote printed") //This message is just to assert from the testcase
    }
  }

  //We'll cover the purpose of this method in the Testing section
  def quoteList=quotes
}
