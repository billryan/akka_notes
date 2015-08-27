package me.yuanbin.akkanotes.requestresponse

import akka.actor.ActorSystem
import akka.actor.Props
import me.yuanbin.akkanotes.actormsg.{StudentActor, TeacherActor}
import me.yuanbin.akkanotes.protocols.StudentProtocol._

object DriverApp extends App {
  //Initialize the ActorSystem
  val system = ActorSystem("UniversityMessageSystem")

  //create the teacher actor
  val teacherRef = system.actorOf(Props[TeacherActor], "teacherActor")

  //create the Student Actor - pass the teacher actorref as a constructor parameter to StudentActor
  val studentRef = system.actorOf(Props(new StudentActor(teacherRef)), "studentActor")

  //send a message to the Student Actor
  studentRef ! InitSignal

  //Let's wait for a couple of seconds before we shut down the system
  Thread.sleep(2000)

  //Shut down the ActorSystem.
  system.shutdown()
}
