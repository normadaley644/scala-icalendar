/**
  * The scala-icalendar unit tests follow the structure of RFC5545
  */
package icalendar

import scala.language.implicitConversions

import org.scalatest._
import org.scalatest.matchers._

package object ical {

  def haveLines(lines: String*): Matcher[String] = Matchers.equal(lines.mkString("\r\n") + "\r\n")
}
