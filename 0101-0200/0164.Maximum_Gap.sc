//153ms





object Solution {
    def maximumGap(nums: Array[Int]): Int = {
        if (nums.length < 2) return 0
  
        val n = nums.length
        val minNum = nums.min
        val maxNum = nums.max
        val bucketSize = math.max((maxNum - minNum) / (n - 1), 1)
        val bucketNum = (maxNum - minNum) / bucketSize + 1
        
        val buckets = Array.fill(bucketNum)((Int.MaxValue, Int.MinValue))
        
        for (num <- nums) {
            val bucketIndex = (num - minNum) / bucketSize
            val (bucketMin, bucketMax) = buckets(bucketIndex)
            buckets(bucketIndex) = (math.min(bucketMin, num), math.max(bucketMax, num))
        }
        
        var maxGap = 0
        var lastMax = minNum
        
        for (bucket <- buckets) {
            val (bucketMin, bucketMax) = bucket
            if (bucketMin != Int.MaxValue) {
                maxGap = math.max(maxGap, bucketMin - lastMax)
                lastMax = bucketMax
            }
        }
        
        maxGap
    }
}






//83ms






object Solution {
    def maximumGap(nums: Array[Int]): Int = {
        if (nums.length < 2)
            return 0
        val sorted = nums.sorted
        var maxDiff = sorted(1) - sorted(0)
        for (i <- 1 to nums.length - 2) {
            val diff = sorted(i + 1) - sorted(i)
            if (diff > maxDiff)
                maxDiff = diff
        }

        return maxDiff
    }
}
