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
