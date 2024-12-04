class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        "Use the hash map data structure to safe the Roman numerals to integers"
        hashMap = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000
        }
        if not s:
            return
        
        results = hashMap[s[0]]
        for i in range(1, len(s)):
            
            if hashMap[s[i]] > hashMap[s[i-1]]:
                # Subtract twice the already added value to current if the 
                # current letter is greater than the previous one
                num = hashMap[s[i]] - hashMap[s[i-1]] - hashMap[s[i-1]]
                results += num
            else:
                # Add the key value if the condition is not met
                results += hashMap[s[i]]
        return results
