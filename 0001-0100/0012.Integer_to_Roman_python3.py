class Solution:
    def intToRoman(self, num: int) -> str:
        mp = [
            ('I' , 1),
            ('IV', 4),
            ('V' , 5),
            ('IX', 9),
            ('X' , 10),
            ('XL', 40),
            ('L' , 50),
            ('XC', 90),
            ('C' , 100),
            ('CD', 400),
            ('D' , 500),
            ('CM', 900),
            ('M' , 1000)
        ]
        
        out = ''
        
        for i in range(len(mp))[::-1]:
            while num >= mp[i][1]:
                out += mp[i][0]
                num -= mp[i][1]
                
        return out
