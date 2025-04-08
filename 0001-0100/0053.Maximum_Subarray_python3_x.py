#75.92%RT


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxSum = nums[0] # Keep track of max sub-array sum
        curSum = 0 # Keep track of current sub-array sum
        
        for num in nums:
            if curSum + num < num:
                curSum = num # Start a new sub-array
            else:
                curSum = curSum + num # Extend from our previous sub-array
            maxSum = max(maxSum, curSum)
        return maxSum
            
