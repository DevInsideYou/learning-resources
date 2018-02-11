// Resource for this video: https://youtu.be/hudjVEXDG0k

object WaysOfCreationPart1Literals {
  def main(args: Array[String]): Unit = {
    println("-" * 50)

    {
      // val a: Byte = 127
      // val a: Byte = 0x7F // 127
      // val a: Byte = 0x7f // 127
      // val a: Byte = 0x80 // 128

      // val b: Long = 9223372036854775807l
      // val b: Long = 9223372036854775807L

      // val c: Char = 'A'
      // val c: Char = 65
      // val c: Char = 0x41 // 65
      // val c: Char = 0x0041
      // val c: Char = '\u0041'


      // println(c.toInt.toChar.toInt.toChar)

      // println(Char.MaxValue)
      // println(Char.MaxValue.toInt)
      // println(Char.MaxValue.toHexString)
      // println(Char.MaxValue.toBinaryString)

      // val c: Char = '\uffff'
      // val c: Char = '\ufffF'
      // val c: Char = '\uFFFF'
      // println(0xffff)
      // println(0xffff: Char)

      // val d: Float = 0.5f
      // val d: Float = 0.5F
      // val d: Float = 5F

      // val e: Double = 0.5
      // val e: Double = 0.5d
      // val e: Double = 0.5D

      // println(0.5E0)
      // println(0.5e0)
      // println(0.05e1)
      // println(0.005e2)
      // println(5e-1)
      // println(50e-2)
      // println(500e-3)
      // println(0.5e+0)
      // println(0.05e+1)
      // println(0.005e+2)

      // println(true)
      // println(false)

      // val f: String = "hello world"

      // val f: String = "hello
      // world"

      // val f: String = """hello
      // world"""

      // val f: String =
      //   """#he llo
      //      # world""".stripMargin('#')

      // val f: String =
      //   """|he llo
      //      | world""".stripMargin

      // val g: Symbol = 'hi

      // val h: String = "hel lo\n world"

      // println("Line Feed (LF)")
      // println("hello\nworld")
      // println()

      // println("Line Feed (LF)")
      // println("hello world")
      // print("hello world\n")
      // println()

      // println("Form Feed (FF)")
      // println("hello\fworld")
      // println()

      // println("Horizontal Tab (HT)")
      // println("hello\tworld")
      // println()

      // println("Backspace (BS)")
      // println("hello\bworld")
      // println()

      // println("Carriage Return (CR)")
      // println("hello\rworld")
      // println("hello\rworld".size)
      // println("hello1234\rworld")
      // println("hello1234\u001b[2K\rworld")
      // println()

      // println("Double quote")
      // println("hello \"w\"orld")
      // println()

      // println("Single quote")
      // println("hello \'w\'orld")
      // println()

      // println("Bashslash")
      // println("hello \\world")
      // println()

      // println("Raw strings")
      // println {
      //   """|hello\n\t\r""\"
      //      |world""".stripMargin
      // }

      // val i: Int => Int = x => x + 1
      // val i: Int => Int = _ + 1

      // val i: (Int, Int) => Boolean =
      //   (left, right) => left == right

      // val i: (Int, Int) => Boolean =



      //   ( _ == _ )



      // println(i(10, 10))
      // println(i(10, 11))
    }

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

    println("-" * 50)
  }
}

// Resource for this video: https://youtu.be/hudjVEXDG0k
