package me.yuanbin.akkanotes.requestresponsetest

import akka.actor.{ActorSystem, Props, actorRef2Scala}
import akka.testkit.{EventFilter, ImplicitSender, TestKit}
import com.typesafe.config.ConfigFactory
import org.scalatest.{BeforeAndAfterAll, MustMatchers, WordSpecLike}
import me.yuanbin.akkanotes.protocols.StudentProtocol._
import me.yuanbin.akkanotes.actormsg.{StudentActor, TeacherActor}


/**
 * This Test case exactly does what the StudentActor was doing in the
 * requestresponse package
 *
 */
class RequestResponseTest extends TestKit(ActorSystem("TestUniversityMessageSystem", ConfigFactory.parseString("""
                                            akka{
                                              loggers = ["akka.testkit.TestEventListener"]
                                              test{
                                                  filter-leeway = 7s
                                              }
                                            }
                                    """)))
  with WordSpecLike
  with MustMatchers
  with BeforeAndAfterAll 
  with ImplicitSender {

 "A student" must {
    "log a QuoteResponse eventually when an InitSignal is sent to it" in {
      val teacherRef = system.actorOf(Props[TeacherActor], "teacherActor")
      val studentRef = system.actorOf(Props(new StudentActor(teacherRef)), "studentActor")
      EventFilter.info (start="Printing from Student Actor", occurrences=1).intercept{
        studentRef ! InitSignal
      }
    }
  }
 
  override def afterAll() {
    super.afterAll()
    system.shutdown()
  }
}