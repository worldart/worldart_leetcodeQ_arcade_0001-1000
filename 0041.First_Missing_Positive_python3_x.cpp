#60.35RT

class Solution:
    def firstMissingPositive(self, a: List[int]) -> int:
        n, i = len(a), 0
        while i < n:
            if 0 < a[i] <= n and a[i] != a[j:=a[i]-1]:
                a[i], a[j] = a[j], a[i]
            else:
                i += 1

        return next((i+1 for i in range(n) if a[i] != i+1), n+1)
