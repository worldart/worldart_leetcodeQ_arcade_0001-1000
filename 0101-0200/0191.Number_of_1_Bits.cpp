//0ms





class Solution {
public:
    int hammingWeight(int n)
    {
        int count = 0;
        while(n>0)
        {
            count += n&1;
            n >>= 1;
        }
        return count;
    }
};






class Solution {
public:
    int hammingWeight(int n) {
        int count = 0; // 1. Initialize a variable 'count' to 0. This counter will store the total number of '1' bits (set bits) found.

        while(n > 0) { // 2. Start a loop that continues as long as the integer 'n' is positive (i.e., there are still bits to examine).
            
            // 3. Check if the rightmost bit of 'n' is a 1 or a 0 using the bitwise AND operator (&).
            //    'n & 1' returns 1 if the last bit is 1, and 0 otherwise.
            //    This result (0 or 1) is immediately added to our running total 'count'.
            count += n & 1; 
            
            // 4. Shift all bits in 'n' one position to the right (right shift operator >>=).
            //    This effectively discards the last bit we just checked and moves the next bit into the rightmost position, preparing it for the next loop iteration.
            n >>= 1;
        }

        // 5. Once the loop terminates (when 'n' becomes 0), return the final accumulated 'count' of 1s.
        return count; 
    }
};






//0ms






class Solution {
public:
    int hammingWeight(int n) {
        return __builtin_popcount(n);
    }
};







class Solution {
public:
    int hammingWeight(int n) {
        // This is a direct, efficient solution leveraging a built-in compiler function.
        
        // 1. The `__builtin_popcount(n)` function is a GCC/Clang built-in intrinsic.
        //    It efficiently calculates the "population count" of the integer `n`. 
        //    "Population count" is a standard computing term for the number of '1' bits in the binary representation of an integer.
        
        // 2. The function delegates the entire task to this optimized intrinsic, 
        //    which is usually implemented directly by highly efficient hardware instructions (e.g., POPCNT on x86 processors).
        
        // 3. The function simply returns the value provided by the built-in call immediately.
        return __builtin_popcount(n);
    }
};
