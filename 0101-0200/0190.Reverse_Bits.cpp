//4ms





class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t ans=0;
        for (int i = 0; i < 32; i++) {
            ans =  ans<<1;
            if(n&1){
                ans=ans|1;
            }
            n = n>>1;
        }
        return ans;
    }
};




class Solution {
public:
    // Function to reverse the bits of a 32-bit unsigned integer
    uint32_t reverseBits(uint32_t n) {

        uint32_t ans = 0;   // This will store the reversed bit result

        for (int i = 0; i < 32; i++) {   // Process all 32 bits
            ans = ans << 1;              // Shift ans left to make space for the next bit

            if (n & 1) {                 // Check if the least-significant bit of n is 1
                ans = ans | 1;           // If yes, set the last bit of ans to 1
            }

            n = n >> 1;                  // Shift n right to process the next bit
        }

        return ans;      // Final reversed 32-bit number
    }
};






//0ms





class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t ans = 0;

        for(int i = 0; i < 32; i++) {
            ans = ans << 1;      // ans me 1 bit ki jagah bana di
            ans = ans | (n & 1); // n ka last bit ans me daal diya
            n = n >> 1;          // n ka last bit hata diya
        }

        return ans;
    }
};





//5ms





class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        
        n = ((n & 0xffff0000) >> 16) | ((n & 0x0000ffff) << 16);
        n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
        
        return n;
        
    }
};







class Solution {
public:
    uint32_t reverseBits(uint32_t n) {

        // Step 1: Swap the higher 16 bits with the lower 16 bits
        // 0xffff0000 = mask for upper 16 bits
        // 0x0000ffff = mask for lower 16 bits
        n = ((n & 0xffff0000) >> 16) | ((n & 0x0000ffff) << 16);

        // Step 2: Swap each 8-bit block inside those 16-bit blocks
        // 0xff00ff00 = mask for bytes [31-24] and [15-8]
        // 0x00ff00ff = mask for bytes [23-16] and [7-0]
        n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8);

        // Step 3: Swap 4-bit chunks (nibbles)
        // 0xf0f0f0f0 = mask for high nibble of each byte
        // 0x0f0f0f0f = mask for low nibble of each byte
        n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4);

        // Step 4: Swap 2-bit pairs
        // 0xcccccccc = 1100 1100 ... (selects left 2 bits of each 4-bit group)
        // 0x33333333 = 0011 0011 ... (selects right 2 bits of each 4-bit group)
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2);

        // Step 5: Swap individual bits
        // 0xaaaaaaaa = 1010 1010 ... (selects bits in even positions)
        // 0x55555555 = 0101 0101 ... (selects bits in odd positions)
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);

        // After these swaps, bits are fully reversed
        return n;
    }
};
