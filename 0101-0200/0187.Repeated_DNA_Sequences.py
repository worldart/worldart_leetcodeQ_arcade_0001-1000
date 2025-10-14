#20ms




class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        left = 0
        res = []
        n = len(s)
        count = {}

        for right in range(9, n):
            curr = s[left:right+1]
            if curr not in count:
                count[curr] = 1
            else:
                if count[curr] == 1:
                    res.append(curr[:])
                    count[curr] += 1
            left += 1
        return res



#1ms



class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if len(s)<10 or len(s)>=10**5:
            return []
        seen,res = set(),set()
        for l in range(len(s)-9):
            cur = s[l:l+10]
            if cur in seen:
                res.add(cur)
            seen.add(cur)
        return list(res)
        
