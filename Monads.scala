// resource fot this video: https://www.youtube.com/watch?v=I2iaaKU1mDg

type RegularFunction[A, B      ] = A =>   B

def ac[A, B, C](
  ab: A => B,
       bc: B => C): A => C = a =>
  val b = ab(a)
  val c = bc(b)

  c

type SpecialFunction[A, B, D[_]] = A => D[B]

trait Monad[D[_]]:
  def flatMap[B, C](db: D[B])(bdc: B => D[C]): D[C]

def adc[A, B, C, D[_]](
  adb: A => D[B],
         bdc: B => D[C])(using monad: Monad[D]): A => D[C] = a =>
  val db = adb(a)
  val dc = monad.flatMap(db)(bdc)

  dc

type    A  = String
type    B  = Int
type    C  = Adult
type D[+E] = Option[E]

def parseString(a: A): D[B] =
  a.toIntOption

case class Adult(age: B)

def keepAdults(b: B): D[C] =
  if b >= 18 then Some(Adult(b)) else None

given Monad[D] with
  def flatMap[B, C](db: D[B])(bdc: B => D[C]): D[C] =
    db match
      case Some(b) => bdc(b)
      case None => None

val parseStringAndThenKeepAdults: A => D[C] =
  adc(parseString, keepAdults) // (using summon[Monad[D]])

object Monads extends App:
  println("─" * 50)

  println(parseStringAndThenKeepAdults("18"))     // Some(Adult(18))
  println(parseStringAndThenKeepAdults("17"))     // None
  println(parseStringAndThenKeepAdults("not Int"))// None

  println("─" * 50)
