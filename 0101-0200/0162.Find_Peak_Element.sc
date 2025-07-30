//8ms





object Solution {
    def findPeakElement(nums: Array[Int]): Int = {
        if(nums.length == 1) return 0

        def helper(left: Int, right: Int, base: Array[Int]): Int = {
            val mid = left + (right-left)/2 
            if(mid == 0) return 1
            else if(left > right) left
            else if(base(mid) > base(mid-1) && base(mid) > base(mid+1)) mid
            else if(base(mid) < base(mid-1)) helper(left, mid-1, base)
            else helper(mid+1, right, base)
        }
        val modi = Int.MinValue +: nums :+ Int.MinValue
        helper(0, modi.length - 1, modi) - 1
    }
}





//0ms





object Solution {
  def findPeakElement(nums: Array[Int]): Int = {
    val N  = nums.length
    var lo = 0
    var hi = N - 1

    while (lo < hi) {
      val mid = lo + ((hi - lo) / 2)

      if (nums(mid) > nums(mid + 1)) {
        hi = mid
      } else {
        lo = mid + 1
      }
    }

    lo
  }
}
