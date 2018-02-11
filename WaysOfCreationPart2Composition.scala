// Resource for this video: https://youtu.be/dLxfbgLXLhw

object WaysOfCreationPart2Composition {
  def main(args: Array[String]): Unit = {
    println("-" * 50)

    {
      printlnMagenta("Widening")

      println()

      {
        val a: Byte = 1   // 1 byte  // 8 bits
        val b: Short = a  // 2 bytes // 16 bits
        val c: Int = b    // 4 bytes // 32 bits
        val d: Long = c   // 8 bytes // 64 bits
        val e: Float = d  // 4 bytes // 32 bits // magnitude is preserved
        val f: Double = e // 8 bytes // 64 bits

        println(a)
        println(b)
        println(c)
        println(d)
        println(e)
        println(f)
      }

      println()

      printlnMagenta("Long vs Float")

      println()

      {
        val a: Byte = 1
        val b: Short = a
        val c: Int = b
        val d: Long = Long.MaxValue
        val e: Float = d
        val f: Double = e

        println(" " + d)
        println(f)
        println(" " + f.toLong)
        println(d == f.toLong)

        println()

        println(5000000d)
        println(5e6)

        println(50000000d)
        println(5e7)
      }

      println()

      printlnMagenta("Widening for Char")

      println()

      {
        val a: Byte = 1
        val b: Char = 'A'
        val c: Int = b
        val d: Long = c
        val e: Float = d
        val f: Double = e

        println(b)
        println(c)
        println(d)
        println(e)
        println(f)
      }

      println()

      printlnMagenta("Narrowing")

      println()

      {
        def s: String = a.toString

        def a: Byte = b.toByte
        def b: Short = c.toShort
        def c: Int = d.toInt
        def d: Long = e.toLong
        def e: Float = f.toFloat
        def f: Double = 1

        println("String\t" + s)

        println()

        println("Double\t" + f)
        println("Float\t" + e)
        println("Long\t" + d)
        println("Int\t" + c)
        println("Short\t" + b)
        println("Byte\t" + a)
      }

      println()

      printlnMagenta("Narrowing from Double.MaxValue")

      println()

      {
        def s: String = a.toString

        def a: Byte = b.toByte
        def b: Short = c.toShort
        def c: Int = d.toInt
        def d: Long = e.toLong
        def e: Float = f.toFloat
        def f: Double = Double.MaxValue

        println("String\t" + s)

        println()

        println("Double\t" + f)
        println("Float\t" + e)
        println("Long\t" + d)
        println("Int\t" + c)
        println("Short\t" + b)
        println("Byte\t" + a)
      }

      println()

      printlnMagenta("Magic Numbers for Float and Double")

      println()

      {
        println(s"Float.NegativeInfinity\t\t" + Float.NegativeInfinity)
        println(s"Float.MinValue\t\t\t" + Float.MinValue)
        println(s"Float.MinPositiveValue\t\t" + Float.MinPositiveValue)
        println(s"java.lang.Float.MIN_VALUE\t" + java.lang.Float.MIN_VALUE)
        println(s"Float.MaxValue\t\t\t" + Float.MaxValue)
        println(s"java.lang.Float.MAX_VALUE\t" + java.lang.Float.MAX_VALUE)
        println(s"Float.PositiveInfinity\t\t" + Float.PositiveInfinity)
        println(s"Float.NaN\t\t\t" + Float.NaN)

        println()

        println(s"Double.NegativeInfinity\t\t" + Double.NegativeInfinity)
        println(s"Double.MinValue\t\t\t" + Double.MinValue)
        println(s"Double.MinPositiveValue\t\t" + Double.MinPositiveValue)
        println(s"java.lang.Double.MIN_VALUE\t" + java.lang.Double.MIN_VALUE)
        println(s"Double.MaxValue\t\t\t" + Double.MaxValue)
        println(s"java.lang.Double.MAX_VALUE\t" + java.lang.Double.MAX_VALUE)
        println(s"Double.PositiveInfinity\t\t" + Double.PositiveInfinity)
        println(s"Double.NaN\t\t\t" + Double.NaN)

        println()

        // println(0 / 0) // java.lang.ArithmeticException: / by zero
        // println(1 / 0) // java.lang.ArithmeticException: / by zero

        println(s"0 / 0\t" + "java.lang.ArithmeticException: / by zero")
        println(s"1 / 0\t" + "java.lang.ArithmeticException: / by zero")

        println()

        println(s"0 / 0d\t" + 0 / 0f) // NaN
        println(s"1 / 0d\t" + 1 / 0f) // Infinity

        println()

        println(s"0 / 0d\t" + 0 / 0d) // NaN
        println(s"1 / 0d\t" + 1 / 0d) // Infinity
      }

      println()

      printlnMagenta("Arithmetic")

      println()

      {
        println(3 + 5)
        println(3.+(5))

        println(3 - 5)
        println(3 * 5)
        println(3 / 5)
        println(3 % 5) // modulo or modulus
      }

      println()

      printlnMagenta("Rest division / Modulo / Modulus")

      println()

      {
        println(-2 % 5)
        println(-1 % 5)
        println( 0 % 5) // 0
        println( 1 % 5)
        println( 2 % 5)
        println( 3 % 5)
        println( 4 % 5)
        println( 5 % 5) // 0
        println( 6 % 5)
        println( 7 % 5)
        println( 8 % 5)
        println( 9 % 5)
        println(10 % 5) // 0

        println()

        println(-2 - ((-2/5)*5))
        println(-1 - ((-1/5)*5))
        println( 0 - (( 0/5)*5)) // 0
        println( 1 - (( 1/5)*5))
        println( 2 - (( 2/5)*5))
        println( 3 - (( 3/5)*5))
        println( 4 - (( 4/5)*5))
        println( 5 - (( 5/5)*5)) // 0
        println( 6 - (( 6/5)*5))
        println( 7 - (( 7/5)*5))
        println( 8 - (( 8/5)*5))
        println( 9 - (( 9/5)*5))
        println(10 - ((10/5)*5)) // 0
      }

      println()

      printlnMagenta("Even")

      println()

      {
        def isEven(x: Int): Boolean =
          x % 2 == 0

        def isOdd(x: Int): Boolean =
          x % 2 != 0 // !isEven(x)

        var i = 0
        while(i <= 10) {
          if(isEven(i))
            println(i)

          i += 1
        }
      }

      println()

      printlnMagenta("Odd")

      println()

      {
        def isEven(x: Int): Boolean =
          x % 2 == 0

        def isOdd(x: Int): Boolean =
          x % 2 != 0 // !isEven(x)

        var i = 0
        while(i <= 10) {
          if(isOdd(i))
            println(i)

          i += 1
        }
      }

      println()

      printlnMagenta("Range")

      println()

      {
        println(0 to 9)
        println(0 until 10)

        println()

        0 to 9 foreach { i =>
          print(i)
        }

        println()

        0 to 9 foreach print // ETA expansion

        println()

        0 until 10 foreach print

        println()

        'A' to 'Z' foreach print

        println()

        'a' to 'z' foreach print

        println()
      }

      println()

      printlnMagenta("Seconds in a minute")

      println()

      {
        val secondsInAMinute = 60

        50 until 70 foreach { i =>
          println(i % secondsInAMinute)
        }
      }

      println()

      printlnMagenta("Degrees in a circle")

      println()

      {
        val degreesInACircle = 360

        350 until 370 foreach { i =>
          println(i % degreesInACircle)
        }
      }

      println()

      printlnMagenta("Comparisons")

      println()

      {
        println(3 <  5)
        println(3 <= 5)
        println(3 == 5)
        println(3 != 5)
        println(3 >= 5)
        println(3 >  5)

        println()

        println(3 <  5d)
        println(3 <= 5d)
        println(3 == 5d)
        println(3 != 5d)
        println(3 >= 5d)
        println(3 >  5d)
      }

      println()

      printlnMagenta("Powers of 2")

      println()

      {
        0 to 16 foreach { i =>
          println(i + "\t" + math.pow(2, i).toInt)
        }
      }

      println()

      printlnMagenta("Min / Max")

      println()

      {
        println(1 min 2)
        println(2 min 1)

        println()

        println(1 max 2)
        println(2 max 1)
      }

      println()

      printlnMagenta("Randomness")

      println()

      {
        def random(max: Int): Int =
          scala.util.Random.nextInt(max)

        1 to 10 foreach { _ =>
          println(random(5))
        }

        println()

        def randomZeroOrOne: Int =
          random(2)

        def randomBoolean: Boolean =
          randomZeroOrOne == 1

        1 to 10 foreach { _ =>
          println(randomBoolean)
        }
      }

      println()

      printlnMagenta("Boolean")

      println()

      {
        println(true)
        println(false)

        println()

        println(!true)
        println(!false)

        println()

        println(true && true && true && true)
        println(true && true && true && false)
        println(false && { println("invisible"); true && true && true })

        println()

        println(false || false || false || false)
        println(false || false || false || true)
        println(true || { println("invisible"); false || false || false })
      }

      println()

      printlnMagenta("String")

      println()

      {
        println("hello world")
        println("hello world".contains("world"))
        println("hello world".contains("hi"))

        // Strings are zero based, so the first character has an index of 0
        println("hello world".substring(1))    // from 2nd to last character
        println("hello world".substring(0, 5)) // from 1st to  5th character

        println("hello world".reverse)
        println("hello world".replace("l", "1"))              // string
        println("hello world".replaceAllLiterally("l", "1"))  // string
        println("hello world".replaceAll("l(.*)", "1"))       // regex

        println()

        println("a" * 3)
        println("hello" + " " + "world") // used to be inefficient

        println()

        val favoriteNumber: Int = 1337

        println("My favorite number is: " + favoriteNumber + ".")
        println(favoriteNumber + " is my favorite number.") // try to avoid that
        println(favoriteNumber.toString + " is my favorite number.") // better

        println("My favorite number is: %s".format(favoriteNumber))

        printf("My favorite number is: %s\n", favoriteNumber)

        println(s"My favorite number is: $favoriteNumber")
        println(s"$favoriteNumber is my favorite number.")

        println(s"My favorite number is: ${FarAway.favoriteNumber}")
        println(s"${FarAway.favoriteNumber} is my favorite number.")

        println(
          "Color %s, number1 %d, number2 %05d, hex %#x, float %5.2f."
            .format("red", 123456, 89, 255, 3.14159)
         )

        println(
          f"Color ${"red"}%s, number1 ${123456}%d, number2 ${89}%05d, hex ${255}%#x, float ${3.14159}%5.2f."
         )
      }

      println()

      printlnMagenta("StdIn (commented out)")

      println()

      {
        // val x = scala.io.StdIn.readLine
        // println(x + 10)
        // println(x.toInt + 10)

        // val x = scala.io.StdIn.readInt

        // val x = scala.io.StdIn.readLine("Favorite number: ")
      }

      println()

      printlnMagenta("Literals")

      println()

      {
        val f: Int => Int = _ + 5
        val g: Int => Int = _ / 2

        println(f(15)) // 15 + 5 = 20
        println(g(20)) // 15 / 2 = 10

        println()

        println(f(g(20))) // (20 / 2) + 5 = 15
        println(g(f(15))) // (15 + 5) / 2 = 10

        println()

        def rightThenLeft(left: Int => Int, right: Int => Int): Int => Int =
          input => left(right(input))

        val gThenF = rightThenLeft(f, g)
        println(gThenF(20))

        def leftThenRight(left: Int => Int, right: Int => Int): Int => Int =
          input => right(left(input))

        val fThenG = leftThenRight(f, g)
        println(fThenG(15))

        println

        val gThenF2 = f compose g
        println(gThenF2(20))

        val fThenG2 = g compose f
        println(fThenG2(15))

        println()

        val gThenF3 = g andThen f
        println(gThenF3(20))

        val fThenG3 = f andThen g
        println(fThenG3(15))
      }

      println()

      printlnMagenta("Referential Equality is the default equality")

      println()

      {
        val f: Int => Int = _ + 5
        val x: Int => Int = _ + 5

        println(f == f)
        println(f == x)

        println()

        println(f eq f)
        println(f ne f)

        println()

        val g: Int => Int = _ + 5
        val y: Int => Int = g

        println(g == g)
        println(g == y)
      }

      println()

      printlnMagenta("Unit")

      println()

      {
        println({} == {})
        println({} == ())
        println(() == {})
        println(() == ())
      }
    }

    println("-" * 50)
  }

  def printlnMagenta(in: String): Unit =
    println(Console.MAGENTA + in + Console.RESET)

  object FarAway {
    val favoriteNumber = 7331
  }
}

// Resource for this video: https://youtu.be/dLxfbgLXLhw
