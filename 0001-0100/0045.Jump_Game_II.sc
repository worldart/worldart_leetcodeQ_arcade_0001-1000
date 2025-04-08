//89.47%RT

object Solution {

    def jump(nums: Array[Int]): Int = {
        val target = nums.length - 1
        var p = 0
        var jumps = 0
        while (p < target) {
            var maxV = 0
            var maxP = 0
            val maxSteps = nums(p)
            if (p + maxSteps < target) {
                for (i <- 1 to maxSteps) {
                    val value = nums(p + i) - (maxSteps - i)
                    if (value >= maxV) {
                        maxV = value
                        maxP = p + i
                    }
                }
                p = maxP
            } else {
                p = target
            }
            jumps += 1
        }
        jumps
    }
}
