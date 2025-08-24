#0ms





class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        a=set(nums)
        maxy=0
        ele=0
        for i in a:
            rep=nums.count(i)
            if rep>=maxy:
                maxy=rep
                ele=i
        return ele





#1ms







class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        median=int(len(nums)/2)
        return(nums[median])
