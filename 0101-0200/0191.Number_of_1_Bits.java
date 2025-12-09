//1ms





public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                res += 1;
            }
        }
        return res;        
    }
}





class Solution {
    public int hammingWeight(int n) {

        int q = 0, r = 0, value = n; 
        // q = quotient after dividing by 2
        // r = running count of 1 bits
        // value = the number we repeatedly divide (initially n)

        do {
            q = value / 2;     
            // divide the current value by 2 (integer division)
            // this is equivalent to shifting the bits right by 1

            r += value % 2;    
            // add the remainder of value / 2
            // remainder is 1 when the least significant bit is 1
            // remainder is 0 when the least significant bit is 0

            value = q;         
            // update value to the quotient to continue processing the next bit

        } while (q != 0);      
        // continue until the value becomes 0 (all bits processed)

        return r;             
        // r now holds the count of '1' bits (Hamming weight)
    }
}







//oms





class Solution {
    public int hammingWeight(int n) {
        int count = 0 ;
        while(n != 0 ) {
            if((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}








class Solution {
    public int hammingWeight(int n) {

        int count = 0;       
        // count will store how many 1-bits we find

        while (n != 0) {     
            // loop until all bits of n have been processed

            if ((n & 1) == 1) {  
                // (n & 1) checks the least significant bit (LSB)
                // If LSB is 1, then (n & 1) equals 1
                count++;         
                // increment count because we found a 1-bit
            }

            n >>= 1;          
            // shift n one bit to the right
            // this discards the current LSB and moves the next bit into place
        }

        return count;        
        // return the total number of 1-bits
    }
}






//1ms






class Solution {
    public int hammingWeight(int n) {
        int q=0,r=0,value=n;
        do {
            q=value/2;
            r+=value%2;
            value=q;
        }while (q!=0);
        return r;
    }
}






class Solution {
    public int hammingWeight(int n) {

        int q = 0, r = 0, value = n;
        // q = quotient after dividing by 2
        // r = count of 1-bits (Hamming weight)
        // value = the current number we are processing, starting with n

        do {
            q = value / 2;
            // divide current value by 2 (integer division)
            // this is like shifting the bits to the right by 1

            r += value % 2;
            // add the remainder of value / 2
            // remainder is 1 → last bit is 1
            // remainder is 0 → last bit is 0
            // so this effectively counts the least significant bit

            value = q;
            // update value to the quotient so we can process the next bit

        } while (q != 0);
        // continue until the number becomes 0 (no bits left to process)

        return r;
        // return the total number of 1 bits found
    }
}








//1ms





class Solution {
    public int hammingWeight(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (char c : binaryString.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }

        return count;
    }
}





class Solution {
    public int hammingWeight(int n) {

        String binaryString = Integer.toBinaryString(n);
        // Convert the integer n into its binary string representation.
        // Example: n = 5 → "101", n = 11 → "1011"
        // This gives a string of '0' and '1' characters.

        int count = 0;
        // count will store the total number of '1' characters we find.

        for (char c : binaryString.toCharArray()) {
            // Convert the string into a character array and iterate over each character.
            // Each character is either '0' or '1'.

            if (c == '1') {
                // Check if the current character represents a bit with value 1.
                count++;  
                // Increase the counter for each '1' bit found.
            }
        }

        return count;
        // Return the total number of '1' bits (the Hamming weight).
    }
}





