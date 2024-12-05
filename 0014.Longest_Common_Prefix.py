
class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 1 : # To improve execution time, always remove special use cases at the beginning.
            return strs[0]
        pref_res = ""
        
        # Compare just two first elms, and get the longest prefix, after that continue looping over rest of elms and remove prefixs
        for i in range(0, min(len(strs[0]), len(strs[1]))): 
            if strs[0][i] != strs[1][i] : 
                break 
            
            pref_res += strs[0][i]
            
        # Now we have something to start with, we'll continue to check on rest array and remove  any char that doesn't match  :
        for rest_char in strs[2:]: 
            while pref_res != rest_char[:len(pref_res)] : # Removing not matching chars
                pref_res = pref_res[:-1]

        
        return pref_res
