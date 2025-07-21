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
