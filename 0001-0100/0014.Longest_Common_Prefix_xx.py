class Solution(object):
    def longestCommonPrefix(self, strs):
        str_result=""
        zip_list = zip(*strs)
        for x in zip_list:
            if len(set(x))==1:
              str_result+=x[0]  
            else:
                break
        return str_result
         
       
        
