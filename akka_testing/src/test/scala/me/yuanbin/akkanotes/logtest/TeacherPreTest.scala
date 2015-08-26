package me.yuanbin.akkanotes.logtest

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import akka.testkit.TestKit
import org.scalatest.BeforeAndAfterAll
import org.scalatest.MustMatchers
import org.scalatest.WordSpecLike
import me.yuanbin.akkanotes.actorlog.TeacherLogActor
import me.yuanbin.akkanotes.protocols.StudentProtocol._

class TeacherPreTest extends TestKit(ActorSystem("UniversityMessageSystem"))
  with WordSpecLike
  with MustMatchers
  with BeforeAndAfterAll {
    "A teacher with ActorLogging" must {
      "log a quote when a QuoteRequest message is sent" in {
        val teacherRef = TestActorRef[TeacherLogActor]
        teacherRef ! QuoteRequest
      }
  }

  override def afterAll() {
    super.afterAll()
    system.shutdown()
  }
}
