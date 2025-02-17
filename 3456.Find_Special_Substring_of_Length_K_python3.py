#0ms 


class Solution:
    def hasSpecialSubstring(self, s: str, k: int) -> bool:
        my_s = s[0]
        for i in range(1, len(s)):
            if my_s[-1] == s[i]:
                my_s += s[i] 
            else:
                my_s += " "
                my_s += s[i]
        my_l = my_s.split(" ")
        for i in my_l:
            if len(i) == k:
                return True
        return False
