class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        n = len(nums)
        res = sum(nums[:3])
        i = 0
        for i in range(n - 2):
            left = i + 1
            right = n - 1
            while left != right:
                diff = abs(res - target)
                minimum = nums[i] + nums[left] + nums[left + 1]
                if target < minimum:
                    if diff > abs(minimum - target):
                        res = minimum
                    break
                maximum = nums[i] + nums[right] + nums[right - 1]
                if target > maximum:
                    if diff > abs(maximum - target):
                        res = maximum
                    break
                    
                s = nums[i] + nums[left] + nums[right]
                if s == target:
                    return s
                if abs(s - target) < diff:
                    res = s
                if s > target:
                    right -= 1
                    while left != right and nums[right] == nums[right + 1]:
                        right -= 1
                else:
                    left += 1
                    while left != right and nums[left] == nums[left - 1]:
                        left += 1

        return res
        
