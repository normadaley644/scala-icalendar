package icalendar

abstract class Property[T <: ValueType] { self: Product =>
    lazy val name = nameFromClassName(this)

    val parameters = self.productIterator.collect {
      case Some(p: PropertyParameter[_]) => p
      case p: PropertyParameter[_] => p
    }.toList
    val value: T
  }

object Properties {
  import ValueTypes._
  import PropertyParameters._

  case class Attach(value: EitherType[Uri, Binary]) extends Property[EitherType[Uri, Binary]]
  case class Dtstamp(value: DateTime) extends Property[DateTime]
  object Dtstamp {
    def now(): Dtstamp = Dtstamp(System.currentTimeMillis)
  }

  case class Uid(value: Text) extends Property[Text]
  case class Description(value: Text, altrep: Option[Altrep]) extends Property[Text]
  case class Organizer(value: CalAddress) extends Property[CalAddress]
  case class Attendee(value: CalAddress) extends Property[CalAddress]
}
