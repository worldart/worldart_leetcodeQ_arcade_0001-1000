//10m s





object Solution {
    def rob(nums: Array[Int]): Int = {
        nums.foldRight((0, 0)) {
            case (v, (v1, v2)) => (math.max(v1, v + v2), v1)
        }._1
    }
}







//1ms







object Solution {
    def rob(nums: Array[Int]): Int = {
        val memo = Array.fill(nums.length){-1}
        loop(nums, memo, 0, 0)
    }

    def loop(nums: Array[Int], memo: Array[Int], i: Int, sum: Int): Int = {
        if (i >= nums.length) sum
        else if (memo(i) != -1) memo(i) + sum
        else {
            val sum1 = loop(nums, memo, i + 1, sum)
            val sum2 = loop(nums, memo, i + 2, sum + nums(i))
            memo(i) = math.max(sum1, sum2)
            memo(i)
        }
    }





//1ms






object Solution {
    def rob(nums: Array[Int]): Int = {
        val memo = Array.fill(nums.length)(-1)

        def solve(step: Int): Int = {
            if step >= nums.length then 0
            else if memo(step) != -1 then memo(step)
            else {
                val res = Math.max(nums(step) + solve(step + 2), solve(step + 1))
                memo(step) = res
                res
            }
        }

        Math.max(solve(0), solve(1))
    }
}







//3ms






import scala.annotation.tailrec

object Solution {
  def rob(nums: Array[Int]): Int = {
    @tailrec
    def solve(idx: Int, prev: Int, curr: Int): Int =
      if idx == nums.length then curr
      else solve(idx + 1, curr, curr.max(prev + nums(idx)))

    solve(1, 0, nums(0))
  }
}
}
