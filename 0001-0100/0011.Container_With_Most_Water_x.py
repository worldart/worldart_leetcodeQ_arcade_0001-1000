class Solution(object):
    def maxArea(self, height):
        left_pointer = 0
        right_pointer = len(height) - 1
        max_water = min(height[left_pointer], height[right_pointer]) *  right_pointer - left_pointer
        while left_pointer < right_pointer:
            if height[left_pointer] < height[right_pointer]:
                left_pointer += 1
            else:
                right_pointer -=1
            max_water = max(max_water, min(height[left_pointer], height[right_pointer]) *  (right_pointer - left_pointer))
        return max_water


        
