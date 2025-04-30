//36ms



object Solution {
    def maxProfit(prices: Array[Int]): Int = {
      prices.foldLeft(Int.MaxValue, 0, Int.MaxValue, 0){case((buy1, profit1, buy2, profit2), price) => 
        (math.min(buy1, price)
        , math.max(profit1, price - buy1)
        , math.min(buy2, price - math.max(profit1, price - buy1))
        , math.max(profit2, price - math.min(buy2, price - math.max(profit1, price - buy1))))
      }._4
    }
}




//18ms


object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.length < 2) return 0
    
    // Initialize states for first transaction
    var buy1 = Int.MaxValue
    var profit1 = 0
    
    // Initialize states for second transaction
    var buy2 = Int.MaxValue
    var profit2 = 0
    
    for (price <- prices) {
      // First transaction
      buy1 = math.min(buy1, price)
      profit1 = math.max(profit1, price - buy1)
      
      // Second transaction (using profit from first)
      buy2 = math.min(buy2, price - profit1)
      profit2 = math.max(profit2, price - buy2)
    }
    
    profit2
  }
}
