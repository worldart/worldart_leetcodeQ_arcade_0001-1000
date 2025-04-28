//1ms

object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    var maxProfit = 0
    var buyPrice = Int.MaxValue

    var i = 0
    while(i < prices.length-1) {
      if(prices(i+1) > prices(i)) {
        maxProfit += prices(i+1) - prices(i)
      } 
      i += 1
    }
    maxProfit
  }
}
