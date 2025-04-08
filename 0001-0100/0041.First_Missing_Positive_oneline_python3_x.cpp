#40.99%RT

class Solution:
    def firstMissingPositive(self, a: List[int]) -> int:
        return next(p+1 for p,q in pairwise(sorted(a+[0,inf])) if p>=0<q-p-1)
