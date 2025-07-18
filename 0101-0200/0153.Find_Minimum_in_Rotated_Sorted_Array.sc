//0ms





object Solution {
  def findMin(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def binarySearch(l: Int, r: Int): Int = {
      if (l == r) nums(l)
      else {
        val m = (l + r) / 2
        if (nums(m) < nums(r)) binarySearch(l, m)
        else binarySearch(m + 1, r)
      }
    }
    binarySearch(0, nums.length - 1)
  }
}




//0ms





object Solution {
  def findMin(nums: Array[Int]): Int = {
    var min = Int.MaxValue

    var left = 0
    var right = nums.length - 1

    while(left <= right) {
      val mid = left + (right - left)/2

      if (nums(mid) < min) {
        min = nums(mid)
      }

      if (nums(mid) < nums(right)) {
        right = mid - 1
      } else {
        left = mid + 1
      }
    }

    min
  }
}
