#0ms



class Solution(object):
    def search(self, nums, target):
        # Initialize the search boundaries
        left, right = 0, len(nums) - 1
        
        # Perform binary search while the search range is valid
        while left <= right:
            # Calculate the middle index
            mid = (left + right) // 2
            
            # Check if the middle element is the target
            if nums[mid] == target:
                return True
            
            # Handle duplicates: If left, mid, and right elements are the same,
            # increment/decrement boundaries to skip duplicates
            if nums[left] == nums[mid] == nums[right]:
                left += 1
                right -= 1
                continue
            
            # Determine which half of the array is sorted
            if nums[left] <= nums[mid]:  # Left half is sorted
                # Check if the target lies within the sorted left half
                if nums[left] <= target < nums[mid]:
                    right = mid - 1  # Narrow the search range to the left half
                else:
                    left = mid + 1   # Narrow the search range to the right half
            else:  # Right half is sorted
                # Check if the target lies within the sorted right half
                if nums[mid] < target <= nums[right]:
                    left = mid + 1   # Narrow the search range to the right half
                else:
                    right = mid - 1  # Narrow the search range to the left half
        
        # If we exit the loop, the target was not found
        return False
