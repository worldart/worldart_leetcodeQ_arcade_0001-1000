#0ms

class Solution:
    def numTrees(self, n: int) -> int:
        return int(prod((4*i+2) / (i+2) for i in range(n)))
