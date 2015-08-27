package me.yuanbin.akkanotes.actormsg

import akka.actor.{Actor, ActorLogging, ActorRef}
import me.yuanbin.akkanotes.protocols.StudentProtocol._
import me.yuanbin.akkanotes.protocols.TeacherProtocol._

/*
 * The Student Actor class. 
 * 
 */
class StudentActor (teacherActorRef:ActorRef) extends Actor with ActorLogging {
  def receive = {
    /*
     * This InitSignal is received from the DriverApp. 
     * On receipt, the Student sends a message to the Teacher actor. 
     * The teacher actor on receipt of the QuoteRequest responds with a QuoteResponse 
     */
    case InitSignal=> {
      teacherActorRef ! QuoteRequest
    }

    /*
     * The Student simply logs the quote received from the TeacherActor
     * 
     */
    case QuoteResponse(quoteString) => {
      log.info("Received QuoteResponse from Teacher")
      log.info(s"Printing from Student Actor $quoteString")
    }
  }
}