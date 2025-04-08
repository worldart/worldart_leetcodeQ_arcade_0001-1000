#5.07%RT

class Solution:
    def firstMissingPositive(self, n: List[int]) -> int:
        return min({*range(1,9**6)}-{*n})
