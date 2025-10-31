//35ms





object Solution {
    def maxProfit(k: Int, prices: Array[Int]): Int = {
      if (k >= prices.length / 2) prices.sliding(2).map(m=> math.max(0, m.last - m.head)).sum
      else {
        val profits = Array.fill(k + 1)(0)
        val buys = Array.fill(k + 1)(Int.MaxValue)
        for (price <- prices)
          for (i <- 1 to k) {
            buys(i) = math.min(buys(i), price - profits(i - 1))
            profits(i) = math.max(profits(i), price - buys(i))
          }
        profits(k)
      }
    }
}





//16ms






object Solution {
  def maxProfit(k: Int, prices: Array[Int]): Int = {

    val len = prices.length
    if (k >= len / 2) {
      var result = 0
      for (i <- 0 until len - 1) {
        if(prices(i + 1) > prices(i)) result += (prices(i+1) - prices(i))
      }
      result
    }
    else {
      val dpCube = Array.ofDim[Int](len, k+1, 2)

      for (j <- 0 to k) dpCube(0)(j)(1) = -prices(0)

      for(i <- 1 until len) {
        for (j <- 1 to k) {
          dpCube(i)(j)(0) = math.max(dpCube(i-1)(j)(0), dpCube(i-1)(j)(1)+prices(i))
          dpCube(i)(j)(1) = math.max(dpCube(i-1)(j)(1), dpCube(i-1)(j-1)(0) - prices(i))
        }
      }

      dpCube(len-1)(k)(0)

    }

  }
}





//14ms






object Solution {
    def maxProfit(k: Int, prices: Array[Int]): Int = {
        val n = prices.length
        val dp = Array.ofDim[Int](n + 1, k + 1, 2)
        (n - 1 to 0 by -1).foreach { i =>
            (1 to k).foreach { l =>
                dp(i)(l)(1) = math.max(dp(i + 1)(l)(0) - prices(i),
                    dp(i + 1)(l)(1))
                dp(i)(l)(0) = math.max(dp(i + 1)(l - 1)(1) + prices(i),
                    dp(i + 1)(l)(0))
            }
        }
        dp(0)(k)(1)
    }
}
