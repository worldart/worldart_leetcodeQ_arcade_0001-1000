//20ms


object Solution {
  def singleNumber(nums: Array[Int]): Int = 
    (0 until 32).foldLeft(0) {
      case (answer, bitIdx) =>
        val bitCount = nums.foldLeft(0) {
          case (count, n) =>
            if (((n >> bitIdx) & 1) == 1) (count + 1) % 3 else count
        }
        if (bitCount != 0) answer | (1 << bitIdx) else answer
    }
}




//8ms



object Solution {
    def singleNumber(nums: Array[Int]): Int = {
         
         var ones = nums(0)
         var twos = 0 

         for (n <- 1 until nums.length) {

            ones = ones ^ nums(n) & ~twos
            twos = twos ^ nums(n) & ~ones

         }

         ones
}
}
