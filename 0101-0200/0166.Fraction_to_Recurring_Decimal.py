#0ms





class Solution(object):
    def fractionToDecimal(self, numerator, denominator):
        if not numerator:
            return "0"

        result = []
        if (numerator < 0) ^ (denominator < 0):
            result.append("-")

        num = abs(numerator)
        den = abs(denominator)

        result.append(str(num // den))
        num %= den

        if not num:
            return "".join(result)

        result.append(".")
        seen = {}

        while num:
            if num in seen:
                result.insert(seen[num], "(")
                result.append(")")
                break
            seen[num] = len(result)
            num *= 10
            result.append(str(num // den))
            num %= den

        return "".join(result)






#0ms






class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator == 0:
            return "0"
        
        fraction = []
        if (numerator < 0) !=  (denominator < 0):
            fraction.append("-")
        
        numerator = abs(numerator)
        denominator = abs(denominator)

        fraction.append(str(numerator//denominator))
        remainder = numerator % denominator
        if remainder == 0:
            return "".join(fraction)
        
        fraction.append(".")
        mapping = {}
        while remainder != 0:
            if remainder in mapping:
                fraction.insert(mapping[remainder], "(")
                fraction.append(")")
                break
            mapping[remainder] = len(fraction)
            remainder *= 10
            fraction.append(str(remainder // denominator))
            remainder %= denominator
        
        return "".join(fraction)
        


        
