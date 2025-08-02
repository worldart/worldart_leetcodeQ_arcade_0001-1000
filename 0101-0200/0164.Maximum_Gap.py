#179ms



class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        a=sorted(nums)
        b=0
        for i in range(1,len(a)):
            c=a[i]-a[i-1]
            b=max(b,c)
        return b





#38ms



import numpy as np

class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        if len(nums) < 2: return 0
        return int(np.max(np.diff(np.sort(nums))))
        




#58ms




class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        nums_set = set(nums)
        prev = min(nums)
        max_gap = 0
        for num in sorted(nums_set):
            if num - prev > max_gap:
                max_gap = num - prev
            prev = num
        return max_gap
