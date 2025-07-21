#0ms



class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        ans = 5001
        while left <= right:
            mid = (left + right) // 2
            ans = min(ans, nums[mid])
            if nums[left] == nums[mid] == nums[right]:
                left += 1
                right -= 1
            elif nums[left] <= nums[mid]:
                ans = min(ans, nums[left])
                left = mid + 1
            else:
                right = mid - 1
        return ans





#0ms





class Solution:
    def findMin(self, nums: List[int]) -> int:
        def search(l: int, r: int) -> int:
            while l < r:
                m = l + (r - l) // 2

                if nums[l] == nums[r]:
                    return min(search(l, m), search(m + 1, r))
                elif nums[m] <= nums[r]:
                    r = m
                else:
                    l = m + 1

            return nums[l]

        return search(0, len(nums) - 1)
