package client

import server.s._

import org.slf4j.LoggerFactory

object c {

  val log = LoggerFactory.getLogger(getClass)

  def main(args: Array[String]) {

    execute { () => 1 + 1 }    


  }

}
