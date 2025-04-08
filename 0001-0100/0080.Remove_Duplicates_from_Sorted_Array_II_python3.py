#65ms 55.24%

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        num_vocabulary = {}
        nums_copy = nums.copy()
        k = 0

        for num in nums_copy:
            if num not in num_vocabulary:
                num_vocabulary[num] = 1
            else:
                num_vocabulary[num] += 1
            
            if num_vocabulary[num] > 2:
                continue 
            else:
                nums[k] = num
                k += 1

        return k



            
