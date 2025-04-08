class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        key = {"M": 1000, "D": 500, "C": 100, "L": 50, "X": 10, "V": 5, "I": 1}
        total = key[s[0]]

        for x in range(1, len(s)):
            if key[s[x]] > key[s[x-1]]:
                # this is one of the weird numbers
                total += key[s[x]] - key[s[x-1]]
                total -= key[s[x-1]]
            else:
                total += key[s[x]]

        return total
