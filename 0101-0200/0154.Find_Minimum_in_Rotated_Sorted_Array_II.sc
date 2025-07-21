//0ms




object Solution {
  def findMin(nums: Array[Int]): Int = {
    findMin(nums, 0, nums.length - 1)
  }

  def findMin(nums: Array[Int], start: Int, end:Int): Int = {
    if (start == end) return nums(start)
    val mid = (start + end) / 2
    if (nums(mid) > nums(start) && nums(mid) > nums(end)) {
      findMin(nums, mid + 1, end)
    } else if (nums(mid) < nums(start) && nums(mid) < nums(end)) {
      findMin(nums, start, mid)
    } else Math.min(findMin(nums, start, mid), findMin(nums, mid + 1, end))
  }
}





//0ms





object Solution {
    /**
        Same as binary search to find as pivot point 
        with an additional condition

        IMP: If nums(l) == nums(m) == nums(r)
             then we have found a duplicate 
             so move both l and r
    */
    def findMin(nums: Array[Int]): Int = {
        
        var l = 0
        var r = nums.length-1

        while (l < r) {
            var m = l + (r-l)/2

            // we have found a duplicate
            // move both l and r
            if (nums(l) == nums(m) && nums(m) == nums(r)) {
                l += 1
                r -= 1
            }
            else if (nums(m) > nums(r)) l = m+1
            else r = m
        }
        nums(l)
    }
}
