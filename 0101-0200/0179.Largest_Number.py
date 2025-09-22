#3ms







class Solution(object):
    def largestNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        a = [str(i) for i in nums]
        a.sort(cmp=lambda x, y: -1 if x + y > y + x else (1 if x + y < y + x else 0))
        s = "".join(a)
        while len(s) > 1 and s[0] == '0':
            s = s[1:]
        return s





#0ms





class Solution(object):
    def largestNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        vals = [str(i) for i in nums]
        vals = sorted(vals,reverse=True,key=lambda a:a*10)
        if vals[0] == "0":
            return "0"
        return "".join(vals)
