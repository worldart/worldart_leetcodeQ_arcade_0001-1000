class Solution(object):
    def reverse(self, x):
        r = 2**31
        x=str(x)
        c=0
        if "-" in x:
            x=x.replace('-', '')
            c = 1
        x = x[::-1]
        if int(x)<=-r or int(x)>=r:
            return 0
        else:
            if c==1:
                return int("-"+x)
            else:
                return int(x)
