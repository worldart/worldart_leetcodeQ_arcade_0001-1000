//0ms





object Solution {
    private val sumsquares = (0 to 9).flatMap(
        j => (0 to 9).map(i => i * i  + j * j)
    ).toArray

    def isHappy(k: Int): Boolean = {
        var n = k
        while (n >= 10) {
            if (n < 100) n = sumsquares(n)
            else {
                val h6 = n / 10000;  val l4 = n % 10000
                val h2 = h6 / 10000; val m4 = h6 % 10000
                val mh2 = m4 / 100;  val ml2 = m4 % 100
                val lh2 = l4 / 100;  val ll2 = l4 % 100
                n = sumsquares(h2) + sumsquares(mh2) + sumsquares(ml2) + sumsquares(lh2) + sumsquares(ll2)
            }
        }
        ((1 << n) & 0x82) != 0
    }
}





//1ms





object Solution {
    def isHappy(n: Int): Boolean =

        @scala.annotation.tailrec
        def sum(n: Int, acc: Int = 0): Int =
            if n <= 0 then acc
            else
                val lastDigit = n % 10
                sum(n / 10, acc + lastDigit * lastDigit)

        @scala.annotation.tailrec
        def loop(slow: Int, fast: Int): Boolean =
            if fast == 1 then true
            else if slow == fast then false
            else loop(sum(slow), sum(sum(fast)))

        loop(n, sum(n))
}





//21ms





import scala.annotation.tailrec
object Solution {
   def isHappy(n: Int): Boolean = {
    @tailrec
    def squaresRec(n: Int, result: Int = 0): Int = {
      if (n == 0) result
      else 
        squaresRec(n / 10, result + ((n % 10) * (n % 10)))

    }
    @tailrec
    def isHappyRec(n: Int, checked: Set[Int]): Boolean = {
      if (checked.contains(n)) false
      else
        val sq = squaresRec(n)
        sq == 1 || isHappyRec(sq, checked + n)
    }
    
    isHappyRec(n, Set.empty)
  }
}






//21ms







object Solution {
    def isHappy(n: Int): Boolean = {

    val seen = scala.collection.mutable.Set[Int]()
    var current = n

    while (current != 1 && !seen.contains(current)) {

      seen.add(current)
      var sum = 0
      var temp = current

      while (temp > 0) {
        val digit = temp % 10
        sum = sum + digit * digit
        temp = temp / 10
      }

      current = sum
    }

    current == 1
  }
}










