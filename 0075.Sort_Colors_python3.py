#0ms


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        nums.sort()


/*
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        left, right = 0 , len(nums)-1
        i=0

        while i <= right:
            if nums[i]==0:
                nums[i],nums[left]=nums[left],nums[i]
                left+=1
                
            if nums[i]==2:
                nums[i],nums[right]=nums[right],nums[i]
                right-=1
                i-=1
            i+=1
*/
