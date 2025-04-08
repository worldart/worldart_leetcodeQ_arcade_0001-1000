#0ms

class Solution:
    def climbStairs(self, n: int) -> int:
        second_last, last = 0, 1
        for i in range(1, n + 1):
            second_last, last = last, second_last + last
        return last
