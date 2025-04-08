class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """        
        prefix = ''
        count = min(len(strs[i]) for i in range(len(strs))) 
        
        for i in range(count):
            letter = strs[0][i]
            if any(word[i] != letter for word in strs): break
            else:
                prefix = prefix+strs[0][i]
        return prefix
            
