#3ms





class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        while right>left:
            right &=(right-1)
        return right
        




#0ms







class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        return left & (-1 << (left ^ right).bit_length())






#3ms






class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        shift = 0
        
        while left < right:
            left >>= 1
            right >>= 1
            shift += 1
        
        return left << shift
