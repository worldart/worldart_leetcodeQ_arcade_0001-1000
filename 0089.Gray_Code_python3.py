#0ms


from collections import deque
class Solution:
    def grayCode(self, n: int) -> List[int]:
        ans = [0, 1]
        if n == 1:
            return ans
        val = 2
        for _ in range(1, n):
            tmp = [val+num for num in ans]
            ans.extend(reversed(tmp))
            val *= 2
        return ans
