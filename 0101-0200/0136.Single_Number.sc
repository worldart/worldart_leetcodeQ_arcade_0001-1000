//14ms



object Solution {
    def singleNumber(nums: Array[Int]): Int = {
        nums.reduce(_ ^ _)
    }
}



//14ms




object Solution {
    def singleNumber(nums: Array[Int]): Int = nums.foldLeft(0)(_^_);
}




//11ms






object Solution {
    def singleNumber(nums: Array[Int]): Int = {
        if (nums.length > 1) {
            var i = nums(0)
            for (n <- 1 until nums.length) {
                i ^= nums(n)
            }
            i
        } else nums(0)
    }
}




//14





object Solution {
    def singleNumber(nums: Array[Int]): Int = {
     nums.reduce((a,b) => a ^ b)
    }
}
