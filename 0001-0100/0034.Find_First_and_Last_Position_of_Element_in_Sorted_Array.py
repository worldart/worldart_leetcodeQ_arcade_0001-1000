# 100% run time

class Solution:
    def compare(self, state, nums, target):
        n = len(nums)
        l, r, result = 0, n - 1, -1
        while r >= l:
            mid = (r + l) // 2
            if nums[mid] == target:
                result = mid
                if state:
                    r = mid - 1
                else:
                    l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        return result

    def searchRange(self, nums, target):
        s = self.compare(True, nums, target)
        e = self.compare(False, nums, target)
        return [s, e]
