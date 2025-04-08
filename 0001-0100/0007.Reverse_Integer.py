class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        x_str = str(x)
        is_negative = x_str[0] == '-'
        x_str = x_str.replace('-','')
        max_val = (2**31) + (0 if is_negative else -1)
        res = 0
        len_stack = len(x_str)
        x_str = list(x_str)
        x_str.reverse()
        for idx, element in enumerate(x_str):
            e = int(element)
            if len_stack >= 10 and idx == 0 and (e != 1 and e != 2):
                return 0
            power = 10**(len_stack-idx-1)
            if (max_val - res) < (power * e):
                #print("(%d - %d) < (%d * %d)" % (max_val, res, power, e))
                return 0
            else:
                res = res + power * e
        return res * (-1 if is_negative else 1)
