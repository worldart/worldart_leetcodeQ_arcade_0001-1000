//2ms






object Solution {
    def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    
        // use two pointers
        // if i + j > target then shift the right pointer down
        // if i + J < target then shift the left pointer down
        // there is always a solution so :)

        def recurse(currLeftIdx: Int, currRightIdx: Int): Array[Int] = {
            val summed = numbers(currLeftIdx) + numbers(currRightIdx)

            if(summed == target) {
                Array(currLeftIdx + 1, currRightIdx + 1)
            } else if (summed > target) {
                recurse(currLeftIdx, currRightIdx - 1)
            } else {
                recurse(currLeftIdx + 1, currRightIdx)
            }
        }

        recurse(0, numbers.length-1)
    }
}





//2ms




object Solution {
    def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
        var left = 0
        var right = numbers.length - 1
        while (left < right) {
            val sumAt = numbers(left) + numbers(right)
            if sumAt == target then
            return Array(left + 1, right + 1)
            else
            if sumAt < target then
                left += 1
            else right -= 1
        }

        throw new IllegalArgumentException("No solution found`")
    }
}

