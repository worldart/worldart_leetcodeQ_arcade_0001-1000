#100%RT

class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        ref = s.split()
        return len(ref[-1])
