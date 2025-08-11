//34ms





object Solution {
    def fractionToDecimal(numerator: Int, denominator: Int): String = {
      if (numerator == 0) "0"
      else {
        val longNumerator = math.abs(numerator.toLong)
        val longDenominator = math.abs(denominator.toLong)
        val integerPart = (longNumerator / longDenominator).toString
        var decimalPart = ""
        var remainder = longNumerator % longDenominator
        var remaindersMap = Map[Long, Int]()
        while (remainder != 0 && !remaindersMap.contains(remainder)) {
          remaindersMap += (remainder -> decimalPart.length)
          remainder *= 10
          decimalPart += (remainder / longDenominator).toString
          remainder %= longDenominator
        }
        if (remainder != 0) 
          decimalPart = decimalPart.substring(0, remaindersMap(remainder)) + "(" + decimalPart.substring(remaindersMap(remainder)) + ")"
        val sign = if ((numerator < 0) ^ (denominator < 0)) "-" else ""
        if (decimalPart.isEmpty) sign + integerPart else sign + integerPart + "." + decimalPart
      }
    }
}




//34ms




import scala.math.Integral.Implicits._
import scala.math._

object Solution {
  def fractionToDecimal(numerator: Int, denominator: Int): String = {
    val sign = if (signum(numerator) * signum(denominator) == -1) "-" else ""
    s"${sign}${fractionToDecimal(abs(numerator.toLong), abs(denominator.toLong))}"
  }

  private def fractionToDecimal(numerator: Long, denominator: Long): String = {
    numerator /% denominator match {
      case (quot, 0)   => quot.toString
      case (quot, rem) => s"${quot}.${generateFractional(rem, denominator)}"
    }
  }

  @scala.annotation.tailrec
  private def generateFractional(numerator: Long,
                                 denominator: Long,
                                 numeratorToIndex: Map[Long, Int] = Map(),
                                 fractional: String = ""): String = {
    numeratorToIndex.get(numerator) match {
      case Some(index) => s"${fractional.substring(0, index)}(${fractional.substring(index)})"
      case _           => 10 * numerator /% denominator match {
        case (quot, 0)   => fractional + quot
        case (quot, rem) => generateFractional(rem, denominator, numeratorToIndex + (numerator -> fractional.length),
                                               fractional + quot)
      }
    }
  }
}






//23ms






object Solution {
  def fractionToDecimal(numerator: Int, denominator: Int): String = {
    if (numerator == 0) return "0"

    val sb = new StringBuilder
    val sign = if ((numerator < 0) ^ (denominator < 0)) "-" else ""
    sb.append(sign)

    var num = Math.abs(numerator.toLong)
    val den = Math.abs(denominator.toLong)

    // integer part
    sb.append(num / den)
    var remainder = num % den
    if (remainder == 0) return sb.toString

    sb.append(".")
    val seen = scala.collection.mutable.Map[Long, Int]()

    while (remainder != 0) {
      if (seen.contains(remainder)) {
        val idx = seen(remainder)
        sb.insert(idx, "(")
        sb.append(")")
        return sb.toString
      }
      seen(remainder) = sb.length
      remainder *= 10
      sb.append(remainder / den)
      remainder %= den
    }
    sb.toString
  }
}
