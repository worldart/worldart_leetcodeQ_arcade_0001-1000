#47ms



class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        hmap=set(nums)
        c=0
        for n in hmap:
            if n-1 not in hmap:
                l=0
                while n+l in hmap:
                    l+=1
                c=max(c,l)
        return c
            




#34ms

  
  

  class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums: return 0

        sorted_nums = sorted(set(nums))
        # print("[DEBUG]: sorted_nums: {}".format(str(sorted_nums)))

        longest = 1
        current = 1
        last = sorted_nums[0]

        for num in sorted_nums[1:]:
            # print("[DEBUG]: num: {} last: {} current: {} longest: {}".format(num, last, current, longest))
            if num == last+1:
                current += 1
                if current > longest:
                    longest = current
            else:
                current = 1
            last = num

        return longest
