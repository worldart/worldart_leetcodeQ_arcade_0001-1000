//2ms 68.76%

object Solution {
    def climbStairs(n: Int): Int = {
        var secondLast = 0
        var last = 1
        for (i <- 1 to n) {
            val temp = last
            last = secondLast + last
            secondLast = temp
        }
        last
    }
}
