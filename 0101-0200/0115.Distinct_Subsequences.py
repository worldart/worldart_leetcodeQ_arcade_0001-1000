#10ms

class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        ls = len(s)
        lt = len(t)
        if ls < lt:
            return 0
        lk = ls - lt

        dp = []
        for _ in range(lk + 1):
            dp.append([1] + [0]* (lt))

        for x in range(lk + 1):
            for y in range(1, lt + 1):
                tmp = dp[x - 1][y] if x > 0 else 0
                tmp += dp[x][y - 1] if t[y - 1] == s[x + y - 1] else 0
                dp[x][y] = tmp
        
        return dp[lk][lt]
