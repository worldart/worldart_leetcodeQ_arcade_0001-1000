//63ms



object Solution {
  def candy(ratings: Array[Int]): Int = {
    val left  = ratings.tail.scanLeft((1, ratings.head)) { case ((c, r1), r2) => (if (r1 >= r2) 1 else c+1, r2) }
    val right = ratings.init.scanRight((1, ratings.last)){ case (r2, (c, r1)) => (if (r1 >= r2) 1 else c+1, r2) }
    left.zip(right).map { case ((l,_), (r,_)) => l max r }.sum
  }
}


//20ms



object Solution {
  def candy(ratings: Array[Int]): Int = {
    var candies = Array.fill(ratings.length)(1)
    /*
    1,2,87,87,87,2,1 -> 1,2,3,1,3,2,1
    1,2,3,1,0 -> 1,2,3,2,1

     */

    for(i <- 1 until ratings.length) {
      if(ratings(i) > ratings(i-1)) {
        candies(i) = candies(i-1) + 1
      }
    }
    var k = ratings.length-2
    while(k >= 0) {
      if(ratings(k) > ratings(k+1)) {
        candies(k) = Math.max(candies(k), candies(k + 1) + 1)
      }
      k -= 1
    }

    var totalCandies = 0
    for(i <- 0 until candies.length) {
      totalCandies += candies(i)
    }
    totalCandies
  }
}



//27ms




object Solution {
    def candy(ratings: Array[Int]): Int = {
        val candies = new Array[Int](ratings.length)
        candies(0) = 1

        // traverse left to right
        for (i <- 1 until ratings.length) {
            if (ratings(i) > ratings(i - 1)) candies(i) = candies(i - 1) + 1
            else candies(i) = 1
        }

        // traverse right to left
        for (i <- ratings.length - 2 to 0 by -1) {
            if (ratings(i) > ratings(i + 1) && candies(i) <= candies(i+1)) candies(i) = candies(i + 1) + 1
        }

        candies.sum
  }
}
