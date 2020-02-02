abstract class NestedRendering(
    level: Int
  )(
    implicit // Don't use implicit primitive types in production!
    amountOfSpacesToIndentWith: Int = 2
  ) {
  this: Product =>

  final override def toString: String =
    if (productArity == 0)
      productPrefix // for case objects
    else
      s"$productPrefix(\n$currentLevelSpaces$pairs\n$previousLevelSpaces)"

  private[this] lazy val currentLevelSpaces: String =
    " " * (level * amountOfSpacesToIndentWith)

  private[this] lazy val previousLevelSpaces: String =
    " " * ((level - 1) * amountOfSpacesToIndentWith)

  private[this] lazy val pairs: String =
    productElementNames
      .zip(productIterator)
      .map {
        case (key, value) =>
          s"$key = $value"
      }
      .mkString(s"\n$currentLevelSpaces")
}
