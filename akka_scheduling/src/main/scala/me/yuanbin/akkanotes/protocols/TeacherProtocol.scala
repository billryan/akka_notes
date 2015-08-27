package me.yuanbin.akkanotes.protocols

object TeacherProtocol {
  /*
   * The TeacherActor responds back to the Student with this message object
   * The actual quote string is wrapped inside the response.
   *
   */
  case class QuoteResponse(quoteString:String)
}
