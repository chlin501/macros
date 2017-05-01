package server

import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context
import org.slf4j.LoggerFactory

object s {

  val log = LoggerFactory.getLogger(getClass)

  def execute(f: () => Unit): Unit = macro _execute

  def _execute(c: Context)(f: c.Tree): c.Tree = {
    import c.universe._
    f match {
      case q"(..$args) => $body" => {
        log.info(s"args: $args body: $body") 
      }
      case unknown@_ => log.info(s"unknown: $unknown")
    }
    f
  }
}
