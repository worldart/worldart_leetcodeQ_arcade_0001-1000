#0ms


class Solution(object):
    def numDecodings(self, s):
        dp = {}
        def numDecodingsLow(index):
            if index >= len(s):
                return 1
            if s[index] == '0':
                return 0
            if index in dp:
                return dp[index]
            res = numDecodingsLow(index+1)
            if (index+1 < len(s) and 
                ((s[index] == '2' and s[index+1] in "0123456") or
                s[index] == '1')):
                res +=  numDecodingsLow(index+2)
            dp[index] = res
            return res
        return numDecodingsLow(0)
        """
        :type s: str
        :rtype: int
        """
