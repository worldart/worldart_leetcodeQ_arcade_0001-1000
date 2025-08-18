#0ms






class Solution(object):
    def convertToTitle(self, columnNumber):
        # Create an empty string for storing the characters...
        output = ""
        # Run a while loop while columnNumber is positive...
        while columnNumber > 0:
            # Subtract 1 from columnNumber and get current character by doing modulo of columnNumber by 26...
            output = chr(ord('A') + (columnNumber - 1) % 26) + output
            # Divide columnNumber by 26...
            columnNumber = (columnNumber - 1) // 26
        # Return the output string.
        return output






#0ms






class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        colName = ''
        if columnNumber <= 26:
            colName += chr(ord('A') - 1 + columnNumber)
            return colName
        c = columnNumber
        while c > 0:
            c -= 1
            d = c // 26
            r = c % 26
            # print(c, d, r)
            colName += chr(ord('A') + r)
            c = d
        return colName[::-1]
