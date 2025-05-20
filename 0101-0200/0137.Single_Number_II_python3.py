#3ms



class Solution:
    def singleNumber(self, nums: List[int]) -> int:

        ones, twos = 0, 0

        for num in nums:
            # Update ones and twos
            ones = (ones ^ num) & ~twos
            twos = (twos ^ num) & ~ones

        return ones  # The single number remains in "ones"


#3ms same as above


class Solution:
    def singleNumber(self, nums):
        ones, twos = 0, 0

        for num in nums:
            # Update ones and twos
            ones = (ones ^ num) & ~twos
            twos = (twos ^ num) & ~ones

        return ones  # The single number remains in "ones"




#4ms




class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        c = Counter(nums)
        for n, v in c.items():
            if v == 1:
                return n
        
        
        
        
