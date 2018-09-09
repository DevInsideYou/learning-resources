// Resource for this video: https://youtu.be/bCTZvAXf4MY

object HigherKindedTypes extends App {
  println("-" * 50)

  def exampleOfOrderZeroFunction(input: Int): String =
    input.toString

  println(exampleOfOrderZeroFunction(1))
  println(exampleOfOrderZeroFunction(2))

  println("-" * 50)

  def exampleOfOrderOneFunction(orderZeroFunction: Int => String): Set[String] =
    Set(1, 2).map(orderZeroFunction)

  println(exampleOfOrderOneFunction(exampleOfOrderZeroFunction))
  println(exampleOfOrderOneFunction(Console.YELLOW + _ + Console.RESET))

  println("-" * 50)

  def exampleOfOrderTwoFunction(orderOneFunction: (Int => String) => Set[String]): Set[Set[String]] =
    Set[Int => String](
      exampleOfOrderZeroFunction,
      Console.YELLOW + _ + Console.RESET
    ).map(orderOneFunction)

  println(exampleOfOrderTwoFunction(exampleOfOrderOneFunction))
  println(exampleOfOrderTwoFunction(intToString => Set(1, 2).map(intToString)))
  println(exampleOfOrderTwoFunction(Set(1, 2).map))
  println(exampleOfOrderTwoFunction(Set(1, 2).map(_).add("3")))

  val a: Set[Set[String]] = exampleOfOrderTwoFunction(exampleOfOrderOneFunction)
  val b: Set[String] = exampleOfOrderOneFunction(exampleOfOrderZeroFunction)
  val c: String = exampleOfOrderZeroFunction(1)

  println("-" * 50)

  // KindZeroType can be absolutly Any thing. E.g Int, Char, Set[Int], Set[Char]

  trait ExampleOfKindOneType[KindZeroType]

  object ExampleOfKindZeroTypeForInt extends ExampleOfKindOneType[Int]
  object ExampleOfKindZeroTypeForChar extends ExampleOfKindOneType[Char]
  object ExampleOfKindZeroTypeForIntSet extends ExampleOfKindOneType[Set[Int]]
  object ExampleOfKindZeroTypeForCharSet extends ExampleOfKindOneType[Set[Char]]

  trait ExampleOfKindTwoType[KindOneType[_]] {
    def map[KindZeroTypeSource, KindZeroTypeTarget]
      (collection: KindOneType[KindZeroTypeSource])
      (function: KindZeroTypeSource => KindZeroTypeTarget): KindOneType[KindZeroTypeTarget]
  }

  object ExampleOfKindZeroTypeForSet extends ExampleOfKindTwoType[Set] {
    final override def map[KindZeroTypeSource, KindZeroTypeTarget]
      (collection: Set[KindZeroTypeSource])
      (function: KindZeroTypeSource => KindZeroTypeTarget): Set[KindZeroTypeTarget] =
      collection.map(function)
  }

  trait ExampleOfKindTwoTypeWithSourceParameterFixed[KindZeroTypeSource, KindOneType[_]] {
    def map[KindZeroTypeTarget]
      (function: KindZeroTypeSource => KindZeroTypeTarget): KindOneType[KindZeroTypeTarget]
  }

  abstract class ExampleOfKindZeroTypeForSetOfTWithSourceParameterFixed[KindZeroTypeSource]
    extends ExampleOfKindTwoTypeWithSourceParameterFixed[KindZeroTypeSource, Set] {
    def collection: Set[KindZeroTypeSource]

    final override def map[KindZeroTypeTarget]
      (function: KindZeroTypeSource => KindZeroTypeTarget): Set[KindZeroTypeTarget] =
      collection.map(function)
  }

  object ExampleOfKindZeroTypeForOption extends ExampleOfKindTwoType[Option] {
    final override def map[KindZeroTypeSource, KindZeroTypeTarget]
      (collection: Option[KindZeroTypeSource])
      (function: KindZeroTypeSource => KindZeroTypeTarget): Option[KindZeroTypeTarget] =
      collection.map(function)
  }

  object ExampleOfKindZeroTypeForSeq extends ExampleOfKindTwoType[Seq] {
    final override def map[KindZeroTypeSource, KindZeroTypeTarget]
      (collection: Seq[KindZeroTypeSource])
      (function: KindZeroTypeSource => KindZeroTypeTarget): Seq[KindZeroTypeTarget] =
      collection.map(function)
  }
}

// The "star" notation (Sorry for making you scroll to the right)

// Kind Zero Type |             * | a type of kind *
// Kind  One Type |        * -> * | a type constructor which takes a type of kind * and produces a type of kind *
// Kind  Two Type | (* -> *) -> * | a type constructor which takes a type of kind * -> * and produces a type of kind *

// Note that at least in Scala types are not curried, so even though a Map[_, _] takes 2 parameters it is a
// Kind  One Type |  * -> *  -> * | parameters are of Kind Zero | *      | in contrast to being a
// Kind  Two Type | (* -> *) -> * | parameter  is  of Kind  One | * -> *
