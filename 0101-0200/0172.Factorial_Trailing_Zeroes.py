#0ms






class Solution:
    def trailingZeroes(self, n: int) -> int:
        res = 0
        div = 1
        while div < n:
            div *= 5
            res += n // div
        return res






//0ms






class Solution:
    def trailingZeroes(self, n: int) -> int:
        res = 0
        while n > 0:
            n //= 5
            res += n
        return res
