package me.yuanbin.akkanotes.actormsg

import akka.actor.ActorSystem
import akka.actor.Props
import me.yuanbin.akkanotes.protocols.StudentProtocol._

/**
 * Let's have the student as a simple App now instead of an Actor for the first part.
 *
 */
object StudentSimulatorApp extends App {
  //Initialize the ActorSystem
  val actorSystem = ActorSystem("UniversityMessageSystem")

  //construct the Teacher Actor Ref
  val teacherActorRef = actorSystem.actorOf(Props[TeacherActor])

  //send a message to the Teacher Actor
  teacherActorRef ! QuoteRequest

  //Let's wait for a couple of seconds before we shut down the system
  Thread.sleep(2000)

  //Shut down the ActorSystem.
  actorSystem.shutdown()
}
