#97.51%RT


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        last=len(nums)-1
        if last==0:
            return True
        if nums[0]==0:
            return False
        step=0
        while(last>0):
            if nums[last]==0 or nums[last]<step:
                step+=1
            else:
                step=1
            last-=1
        return step<=nums[last]         
        
