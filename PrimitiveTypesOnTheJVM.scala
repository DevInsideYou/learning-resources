// Resource for this video: https://youtu.be/i1kmgX8I4CM

object PrimitiveTypesOnTheJVM {
  def main(args: Array[String]): Unit = {
    println("-" * 130)

    {
      def signedBits(n: Long): Int =
        unsignedBits(n) + 1

      def unsignedBits(n: Long): Int =
        n.toBinaryString.size

      def rendered(`type`: String, min: Long, max: Long, bits: Int): String = {
        val bytes = bits / 8
        val renderedBytesWith = if(bytes == 1) "byte  with" else "bytes with"

        s"${`type`}\thas $bits\t binary digits (bits), which is $bytes $renderedBytesWith\tpossible values: $min .. $max"
      }

      def renderedSigned(`type`: String, min: Long, max: Long): String =
        rendered(`type`, min, max, signedBits(max))

      def renderedUnsigned(`type`: String, min: Long, max: Long): String =
        rendered(`type`, min, max, unsignedBits(max))

      def renderedFloating(`type`: String, min: Double, max: Double): String =
        s"${renderedFirstHalf(`type`)} $min .. $max"

      def renderedFirstHalf(`type`: String): String =
        s"${`type`}\t\t\t\t\t\t\t\tpossible values:"

      println(renderedSigned("Byte", Byte.MinValue, Byte.MaxValue))
      println()

      println(renderedSigned("Short", Short.MinValue, Short.MaxValue))
      println(renderedUnsigned("Char", Char.MinValue, Char.MaxValue))
      println()

      println(renderedSigned("Int", Int.MinValue, Int.MaxValue))
      println(renderedSigned("Long", Long.MinValue, Long.MaxValue))
      println()

      println(renderedFloating("Float", Float.MinValue, Float.MaxValue))
      println(renderedFloating("Double", Double.MinValue, Double.MaxValue))
      println()

      println(s"${renderedFirstHalf("Boolean")} ${true} and ${false}")
      println()

      println(s"${renderedFirstHalf("Unit")} {} or ${()}")
    }

    println("-" * 130)
  }
}

// Resource for this video: https://youtu.be/i1kmgX8I4CM
