//463ms





object Solution {
    def lengthOfLIS(nums: Array[Int]): Int = 
        nums.indices.tail.foldLeft(Map(0 -> 1))((m, idx) => {
            val v = (0 to idx - 1).foldLeft(1)((acc, i) => if(nums(i) >= nums(idx)) acc else math.max(acc, m(i) + 1))
            m.updated(idx, v)
        }).values.max
}






//193ms







object Solution {
  def lengthOfLIS(nums: Array[Int]): Int = {
    val dp = Array.fill(nums.length)(1)

    for {
      l <- 1 until nums.length
      r <- 0 until l 
      if nums(l) > nums(r)
    } dp(l) = Math.max(dp(l), dp(r) + 1)

    dp.max
  }
}





//12ms





object Solution {

  def lengthOfLIS(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0

    val tails = new Array[Int](nums.length)
    var size = 0

    for (num <- nums) {
      var left = 0
      var right = size

      while (left < right) {
        val mid = (left + right) / 2
        if (tails(mid) < num) left = mid + 1
        else right = mid
      }

      tails(left) = num
      if (left == size) size += 1
    }

    size
  }
}
