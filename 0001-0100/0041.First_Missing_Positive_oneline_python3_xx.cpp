#73.08RT

class Solution:
    def firstMissingPositive(self, a: List[int]) -> int:
        return min({*range(1,len(a)+2)}-{*a})
