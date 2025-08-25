#0ms





class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        ans, pos = 0, 0
        for letter in reversed(columnTitle):
            digit = ord(letter)-64
            ans += digit * 26**pos
            pos += 1
            
        return ans






#0ms







class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        col_num = 0
        for char in columnTitle:
            col_num = col_num * 26 + (ord(char) - 64)
        return col_num





#0ms






class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        result=0
        for char in columnTitle:
            result=result*26+(ord(char)-ord('A')+1)
        return result
