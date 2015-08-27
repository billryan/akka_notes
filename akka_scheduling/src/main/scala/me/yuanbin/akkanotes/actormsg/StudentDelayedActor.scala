package me.yuanbin.akkanotes.actormsg

import akka.actor.{Actor, ActorLogging, ActorRef}
import me.yuanbin.akkanotes.protocols.StudentProtocol._
import me.yuanbin.akkanotes.protocols.TeacherProtocol._
import scala.concurrent.duration._

/*
 * The Student Actor that uses Scheduler. 
 * 
 */
class StudentDelayedActor (teacherActorRef:ActorRef) extends Actor with ActorLogging {
  def receive = {
    /*
     * This InitSignal is received from the DriverApp. 
     * On receipt and after 5 seconds, the Student sends a message to the Teacher actor. 
     * The teacher actor on receipt of the QuoteRequest responds with a QuoteResponse 
     */
    case InitSignal=> {
      log.info("StudentDelayedActor initSignal")
      import context.dispatcher
      context.system.scheduler.scheduleOnce(5 seconds, teacherActorRef, QuoteRequest)
      //context.system.scheduler.schedule(0 seconds, 5 seconds, teacherActorRef, QuoteRequest)
      //teacherActorRef!QuoteRequest
    }
    
    case QuoteResponse(quoteString) => {
      log.info ("Received QuoteResponse from Teacher")
      log.info(s"Printing from Student Actor $quoteString")
    }
  }
}