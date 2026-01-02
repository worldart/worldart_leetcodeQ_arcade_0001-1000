#0ms




class Solution:
    def rob(self, nums: List[int]) -> int:
        robbed = [None]*(len(nums)+1)
        robbed[0] = 0
        robbed[1] = nums[0]
        
        for i in range(2,len(nums)+1):
            robbed[i] = max(robbed[i-1], nums[i-1] + robbed[i-2])
        return robbed[len(nums)]





#0ms





class Solution:
    def rob(self, nums: List[int]) -> int:
        
        
        money = [-1 for i in range(len(nums))]
        money[0] = nums[0]
        if len(nums) > 1:
            money[1] = max(nums[0], nums[1])
        def total(n, money):
            if money[n] != -1:
                return money[n]
            t = max(total(n-1, money), total(n-2, money)+nums[n])
            money[n] = t
            return t

        return total(len(nums)-1, money)
