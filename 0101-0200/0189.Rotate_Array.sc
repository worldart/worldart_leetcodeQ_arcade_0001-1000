//11ms





object Solution {
    def rotate(nums: Array[Int], k: Int): Unit = {
        val size = nums.size
        val new_nums = nums.drop(size - (k%size)) ++ nums.take(size - (k%size))
        for (i <- 0 until size) {
            nums(i) = new_nums(i)
        }
    }
}






//0ms






object Solution {
    def rotate(nums: Array[Int], k: Int): Unit = {
        val n = nums.length
        val steps = k % n  // Handle cases where k > n

        def reverse(start: Int, end: Int): Unit = {
            var i = start
            var j = end
            while (i < j) {
                val temp = nums(i)
                nums(i) = nums(j)
                nums(j) = temp
                i += 1
                j -= 1
            }
        }

        reverse(0, n - 1)
        reverse(0, steps - 1)
        reverse(steps, n - 1)
    }
}











