package me.yuanbin.akkanotes.protocols

object StudentProtocol {
  /*
   * the Driver App issues this signal to ask the
   * Student actor to send message to Teacher Actor
   *
   */
  case class InitSignal()

  /*
   * The Student sends this message to request for a Quotation
   *
   */
  case class QuoteRequest()
}
