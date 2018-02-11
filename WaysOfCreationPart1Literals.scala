// Resource for this video: https://youtu.be/hudjVEXDG0k

object WaysOfCreationPart1Literals {
  def main(args: Array[String]): Unit = {
    println("-" * 50)

    {
      printlnMagenta("Numeric")

      println()

      {
        val a: Byte = 127
        println(a)
      }

      {
        val a: Byte = 0x7F // 127
        println(a)
      }

      {
        val a: Byte = 0x7f // 127
        println(a)
      }

      {
        // val a: Byte = 0x80 // 128
      }

      println()

      {
        val b: Long = 9223372036854775807l
        println(b)
      }

      {
        val b: Long = 9223372036854775807L
        println(b)
      }

      println()

      printlnMagenta("Char")

      println()

      {
        val c: Char = 'A'
        println(c)
      }

      {
        val c: Char = 65
        println(c)
      }

      {
        val c: Char = 0x41 // 65
        println(c)
      }

      {
        val c: Char = 0x0041
        println(c)
      }

      {
        val c: Char = '\u0041'
        println(c)

        println()

        println(c.toInt.toChar.toInt.toChar)
      }

      println()

      {
        println(Char.MaxValue)
        println(Char.MaxValue.toInt)
        println(Char.MaxValue.toHexString)
        println(Char.MaxValue.toBinaryString)
      }

      println()

      {
        val c: Char = '\uffff'
        println(c)
      }

      {
        val c: Char = '\ufffF'
        println(c)
      }

      {
        val c: Char = '\uFFFF'
        println(c)
      }

      {
        println(0xffff)
        println(0xffff: Char)
      }

      println()

      printlnMagenta("Float and Double")

      println()

      {
        {
          val d: Float = 0.5f
          println(d)
        }

        {
          val d: Float = 0.5F
          println(d)
        }

        {
          val d: Float = 5F
          println(d)
        }

        println()

        {
          val e: Double = 0.5
          println(e)
        }

        {
          val e: Double = 0.5d
          println(e)
        }

        {
          val e: Double = 0.5D
          println(e)
        }

        println()

        println(0.5E0)
        println(0.5e0)
        println(0.05e1)
        println(0.005e2)
        println(5e-1)
        println(50e-2)
        println(500e-3)
        println(0.5e+0)
        println(0.05e+1)
        println(0.005e+2)
      }

      println()

      printlnMagenta("Boolean")

      println()

      {
        println(true)
        println(false)
      }

      println()

      printlnMagenta("String")

      println()

      {
        val f: String = "hello world"
        println(f)
      }

      println()

      {
        // val f: String = "hello
        // world"
      }

      {
        val f: String = """hello
        world"""

        println(f)
      }

      println()

      {
        val f: String =
          """#he llo
             # world""".stripMargin('#')

        println(f)
      }

      println()

      {
        val f: String =
          """|he llo
             | world""".stripMargin

        println(f)
      }

      println()

      printlnMagenta("Symbol")

      println()

      {
        val g: Symbol = 'hi
        println(g)
      }

      println()

      printlnMagenta("Escape charakters and sequences")

      println()

      {
        val h: String = "hel lo\n world"
        println(h)

        println()

        printlnMagenta("Line Feed (LF)")

        println("hello\nworld")
        println()

        printlnMagenta("Line Feed (LF)")

        println("hello world")
        print("hello world\n")
        println()

        printlnMagenta("Form Feed (FF)")

        println("hello\fworld")
        println()

        printlnMagenta("Horizontal Tab (HT)")

        println("hello\tworld")
        println()

        printlnMagenta("Backspace (BS)")

        println("hello\bworld")
        println()

        printlnMagenta("Carriage Return (CR)")

        println("hello\rworld")
        println("hello\rworld".size)
        println("hello1234\rworld")
        println("hello1234\u001b[2K\rworld")
        println()

        printlnMagenta("Double quote")

        println("hello \"w\"orld")
        println()

        printlnMagenta("Single quote")

        println("hello \'w\'orld")
        println()

        printlnMagenta("Bashslash")

        println("hello \\world")
        println()

        printlnMagenta("Raw strings")

        println {
          """|hello\n\t\r""\"
             |world""".stripMargin
        }
      }

      println()

      printlnMagenta("Function literals")

      println()

      {
        val i: Int => Int = x => x + 1

        println(i)
        println(i(10))
      }

      println()

      {
        val i: Int => Int = _ + 1

        println(i)
        println(i(10))
      }

      println()

      {
        val i: (Int, Int) => Boolean =
          (left, right) => left == right

        println(i)
        println(i(10, 10))
        println(i(10, 11))
      }

      println()

      {
        val i: (Int, Int) => Boolean =
          _ == _

        println(i)
        println(i(10, 10))
        println(i(10, 11))
      }

      println()

      printlnMagenta("Time")

      println()

      {
        def now: String = {
          val formatter =
            java.time.format
              .DateTimeFormatter
              .ofPattern("HH:mm:ss")

          java.time
            .LocalDateTime
            .now
            .format(formatter)
        }

        def inOneLine(in: String): String = {
          val clearLine = "\u001b[2K"
          val carriageReturn = "\r"

          clearLine + carriageReturn + in
        }

        var i = 0

        while(i < 5) {
          Thread.sleep(1 * 1000)
          print("something very very long")
          print(inOneLine(now))

          i += 1
        }

        println()
      }
    }

    println("-" * 50)
  }

  def printlnMagenta(in: String): Unit =
    println(Console.MAGENTA + in + Console.RESET)
}

// Resource for this video: https://youtu.be/hudjVEXDG0k
