#423ms




class Solution:
    def minCut(self, S):
        N = len(S)
        dp = [-1] + [N] * N
        for i in range(2 * N - 1):
            l = i // 2
            r = l + (i & 1)
            while 0 <= l and r < N and S[l] == S[r]:
                dp[r + 1] = min(dp[r + 1], dp[l] + 1)
                l -= 1
                r += 1
        return dp[-1]




#395ms




class Solution:
    def minCut(self, s: str) -> int:
        dp_pal = [[False] * len(s) for _ in range(len(s))]
        for i in range(len(s)):
            r, c = i, i
            while r >= 0 and c < len(s) and s[r] == s[c]:
                dp_pal[r][c] = True
                r -= 1
                c += 1
            r, c = i, i + 1
            while r >= 0 and c < len(s) and s[r] == s[c]:
                dp_pal[r][c] = True
                r -= 1
                c += 1

        dp = [0]
        for end in range(1, len(s)):
            if dp_pal[0][end]:
                dp.append(0)
                continue
            best = dp[-1] + 1
            for start in range(end):
                if dp_pal[start][end]:
                    best = min(best, dp[start - 1] + 1)
            dp.append(best)
        return dp[-1]





#171ms




class Solution:
    def minCut(self, s: str) -> int:
        
        def isPalindrome(i, j):
            while i < j:
                if s[i] != s[j]:
                    return False
                i += 1
                j -= 1
            return True
        
        n = len(s)
        if s == s[::-1]:
            return 0
        
        for i in range(1, len(s)):
            if s[:i] == s[:i][::-1] and s[i:] == s[i:][::-1]:
                return 1
        
        dp = [0] * (n + 1)
        dp[n] = 0

        for i in range(n - 1, -1, -1):
            min_cost = float('inf')
            for j in range(i, n):
                if isPalindrome(i, j):
                    dp[i] = 1 + dp[j + 1]
                    min_cost = min(min_cost, dp[i])
            dp[i] = min_cost
        
        return dp[0] - 1
