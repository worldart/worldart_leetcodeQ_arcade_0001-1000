//11ms





import scala.math.{min, max}

object Solution {
    def maxProduct(nums: Array[Int]): Int = {
        
        var result = nums.head
        var minSoFar = nums.head
        var maxSoFar = nums.head

        nums.tail.foreach { num =>

            val x = num * minSoFar
            val y = num * maxSoFar

            minSoFar = min(num, min(x, y))
            maxSoFar = max(num, max(x, y))

            result = max(result, maxSoFar)
        }

        result
    }
}






//3ms






object Solution {
    def maxProduct(nums: Array[Int]): Int = {
      val n = nums.length
      
      var i = 1
      var runningMin = nums(0)
      var runningMax = nums(0)
      var max = nums(0)

      while(i < n) {
        val nextRunningMin = math.min(math.min(nums(i), runningMin * nums(i)), runningMax * nums(i))
        val nextRunningMax = math.max(math.max(nums(i), runningMin * nums(i)), runningMax * nums(i))
        runningMin = nextRunningMin
        runningMax = nextRunningMax
        i += 1

        max = math.max(max, runningMax)
        max = math.max(max, runningMin)
      }
      
      max
    }
}
