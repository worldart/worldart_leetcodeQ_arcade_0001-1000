class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        def digitToRoman(i, d):
            symbols = 'IVXLCDM__'
            one, five, ten = symbols[i*2 : i*2+3]
            if d<4:
                roman = one*d
            elif d==4:
                roman = one + five
            elif d==5:
                roman = five
            elif d<9:
                roman =  five + one*(d-5)
            else:
                roman = one + ten
            return roman
        
        ## testing function digitToRoman()
        # for i in range(4):
        #     for j in range(1, 10):
        #         print(10**i*j, digitToRoman(i, j))
        
        i, res = 0, ''
        while num:
            num, d = num//10, num%10
            res = digitToRoman(i, d) + res
            i += 1
        return res
