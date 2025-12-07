#1ms



class Solution:
    def hammingWeight(self, n: int) -> int:
        res = 0

        for i in range(32):
            if (n >> i) & 1:
                res += 1

        return res









class Solution:
    def hammingWeight(self, n: int) -> int:
        # 1. Initialize 'res' to 0. This variable will count the total number of '1' bits found.
        res = 0

        # 2. Start a loop that iterates exactly 32 times (from i=0 to i=31).
        #    This covers all standard 32 bits of an integer in many common programming environments/constraints.
        for i in range(32):
            
            # 3. Check the status of the i-th bit from the right.
            #    (n >> i) shifts the number 'n' to the right by 'i' positions, moving the i-th bit to the rightmost position.
            #    The bitwise AND operation (& 1) then isolates that specific rightmost bit (result is 1 or 0).
            if (n >> i) & 1:
                
                # 4. If the result of the check is 1 (the bit is set), increment the result counter.
                res += 1

        # 5. After checking all 32 positions, return the final count of '1' bits.
        return res












#0ms





class Solution:
    def hammingWeight(self, n: int) -> int:
        binary=0
        result=0
        while n>0:
            result+=n&1
            n>>=1
        return result







class Solution:
    def hammingWeight(self, n: int) -> int:
        # Note: The 'binary = 0' variable is unused in this specific logic and can be safely ignored or removed.
        binary=0 

        # 1. Initialize 'result' to 0. This variable acts as our counter for the number of '1' bits found.
        result=0

        # 2. Start a loop that continues as long as the integer 'n' is greater than 0, ensuring all bits are checked.
        while n>0:
            # 3. Use the bitwise AND operator ('&') to check the rightmost (least significant) bit of 'n'.
            #    If the last bit is 1, 'n & 1' yields 1. If it's 0, it yields 0.
            #    This result is immediately added to our 'result' counter.
            result+=n&1
            
            # 4. Right shift 'n' by 1 position (n >>= 1). This operation discards the rightmost bit and moves 
            #    the next bit into the least significant position for the next iteration of the loop.
            n>>=1

        # 5. Once the loop finishes (when n reaches 0), return the final accumulated count of '1' bits.
        return result
