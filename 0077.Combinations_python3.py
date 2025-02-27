#0ms

dic={}
for n in range(1,21):
    comb = [[i] for i in range(1, n+1)]
    for k in range(1, n):
        dic[(n, k)] = comb
        comb = [c + [j] for c in comb for j in range(c[-1]+1, n+1)]
    dic[(n, n)] = comb

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        return dic[(n, k)]
'''
#19ms 99.45%

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        c = combinations(range(1,n+1),k)
        return list(c)

'''
