#3ms 66.85%RT

class Solution(object):
    def hasSpecialSubstring(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: bool
        """
        n = len(s)
        for i in range(n - k + 1):
            substring = s[i:i + k]
            distinct_char = set(substring)

            if len(distinct_char) != 1:
                continue

            valid = True
            if i > 0 and s[i - 1] == substring[0]:
                valid = False
            if i + k < n and s[i + k] == substring[0]:
                valid = False

            if valid:
                return True

        return False
