//8ms





object Solution {
    def majorityElement(nums: Array[Int]): Int = {
        val sorted = nums.sortInPlace
        sorted(nums.length / 2)
    }
}






//3ms





import scala.annotation.tailrec

object Solution {
    def majorityElement(nums: Array[Int]): Int = {
        @tailrec
        def loop(count: Int, candidate: Int, i: Int): Int = {
            if (i >= nums.length) {
                candidate
            } else if (count == 0) {
                loop(count = 1, candidate = nums(i), i = i + 1)
            } else if (nums(i) == candidate) {
                loop(count = count + 1, candidate, i = i + 1)
            } else {
                loop(count = count - 1, candidate, i = i + 1)
            }
        }

        loop(count = 1, candidate = nums(0), i = 1)
    }
}






//2ms






object Solution {
    def majorityElement(nums: Array[Int]): Int = {
        var counter = 1
        var num = nums(0)
        var i = 1
        while (i < nums.length) {
            if (num == nums(i)) {
                counter += 1
            } else {
                counter -= 1
            }
            if (counter == 0) {
                num = nums(i)
                counter = 1
            }
            i += 1
        }
        num   
    }
}
