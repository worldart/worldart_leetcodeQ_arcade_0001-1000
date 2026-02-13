#1245ms





class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        n = len(nums)
        dp = [1] * n

        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)

        return max(dp)








#0ms








class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        
        i = 0
        l = len(nums)
        ans = []
        while i<l:
            if len(ans) == 0 or nums[i]>ans[-1]:
                ans.append(nums[i])
            else:
                idx = bisect_left(ans, nums[i])
                ans[idx]= nums[i]
            i+=1
        return len(ans)








#43ms









class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        best_chain = []
        for num in nums:
            if not best_chain or num > best_chain[-1]:
                best_chain.append(num)                
            else:
                left = 0
                right = len(best_chain)-1
                while left <= right:
                    middle = (left+right) // 2
                    if best_chain[middle] < num:
                        left += 1
                    else:
                        right -= 1
                best_chain[left] = num
        return len(best_chain)
        


