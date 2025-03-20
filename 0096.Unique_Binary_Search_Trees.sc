//12ms

object Solution {
    def numTrees(n: Int): Int = {
        val dp = Array.fill[Int](n+1)(1)
        for (i <- 2 to n) {
            var res = (
                if (i % 2 == 1) dp(i/2)
                else 0
            )
            res *= res
            for (j <- 1 to i/2)
                res += 2 * dp(j-1) * dp(i-j)
            dp(i) = res
        }
        dp(n)
    }
}
