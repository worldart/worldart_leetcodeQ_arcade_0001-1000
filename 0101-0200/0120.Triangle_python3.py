#2ms


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        dp = [0] * n
        dp[0] = triangle[0][0]

        for i in range(1, n):
            for j in range(i, -1, -1):
                if j == i:
                    dp[j] = dp[j - 1] + triangle[i][j]
                elif j == 0:
                    dp[j] = dp[j] + triangle[i][j]
                else:
                    dp[j] = min(dp[j - 1], dp[j]) + triangle[i][j]
        return min(dp)
