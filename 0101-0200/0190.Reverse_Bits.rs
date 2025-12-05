//2ms




impl Solution {
    pub fn reverse_bits(n: i32) -> i32 {
        n.reverse_bits()        
    }
}







// Defines a structure named 'Solution'. This is a standard convention 
// in many coding challenge platforms (like LeetCode) to organize code, 
// even though the struct itself has no fields or state here.
impl Solution {

    // Defines a public function named 'reverse_bits' within the Solution structure.
    // It accepts one argument, 'n', which is a 32-bit signed integer (i32),
    // and it is declared to return a 32-bit signed integer (i32).
    pub fn reverse_bits(n: i32) -> i32 {

        // This is the core line of logic.
        // Rust's primitive integer types (`i32`, `u32`, etc.) have a built-in 
        // method called `.reverse_bits()` provided by the standard library.
        // It efficiently performs the exact operation requested by the problem.
        // The return value of this method is automatically returned by the function.
        n.reverse_bits()        
    }

// Closes the implementation block.
}





//2ms






impl Solution {
    pub fn reverse_bits(n: i32) -> i32 {
        let (mut res, mut n) = (0u32, n as u32);
        for _ in 0..32 {
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        res as i32
    }
}







// This defines an 'implementation block' for a struct named 'Solution'. 
// This is a common pattern in coding challenges (like LeetCode) to organize methods.
impl Solution {

    // This declares a public function named 'reverse_bits'. 
    // It takes one argument 'n' (a 32-bit signed integer, i32) 
    // and promises to return a 32-bit signed integer (i32).
    pub fn reverse_bits(n: i32) -> i32 {

        // This line initializes two mutable variables using a tuple pattern:
        // 1. `res` (result): starts at 0, explicitly typed as `u32` (unsigned 32-bit integer).
        // 2. `n` (input copy): the original `i32` input is cast (`as u32`) to an unsigned 32-bit integer 
        //    to allow uniform bitwise operations inside the loop.
        let (mut res, mut n) = (0u32, n as u32);

        // This initiates a loop that runs exactly 32 times (from 0 up to, but not including, 32).
        // The `_` means we don't care about the loop index variable itself, just that it runs 32 times.
        for _ in 0..32 {

            // This is the core logic line:
            // 1. `(res << 1)`: Shifts the current result one position to the left, making space for the next bit.
            // 2. `(n & 1)`: Extracts the Least Significant Bit (LSB) of the input `n` (this will be 0 or 1).
            // 3. `|`: Uses the bitwise OR operator to place that extracted bit into the newly opened space in `res`.
            res = (res << 1) | (n & 1);

            // Shifts the input `n` one position to the right, discarding the bit we just processed 
            // and moving the *next* bit we need to the LSB position for the next loop iteration.
            n >>= 1;

        // The loop ends here. After 32 iterations, `res` holds all original bits in reverse order.
        }

        // Before returning, the final unsigned result (`u32`) is cast back 
        // to a signed 32-bit integer (`i32`) to match the function's return type signature.
        res as i32

    // The function definition ends here.
    }
// The implementation block ends here.
}








//0ms








impl Solution {
    pub fn reverse_bits(n: i32) -> i32 {
        // 1. Cast the input 'n' to a u32 type and make it mutable
        let mut n_u = n as u32; 

        // 2. Perform all operations on the unsigned integer 'n_u'
        // We also append 'u32' to the masks to explicitly define them as unsigned literals
        n_u = (n_u & 0b11111111111111110000000000000000u32) >> 16 | (n_u & 0b00000000000000001111111111111111u32) << 16;
        n_u = (n_u & 0b11111111000000001111111100000000u32) >> 8  | (n_u & 0b00000000111111110000000011111111u32) << 8;
        n_u = (n_u & 0b11110000111100001111000011110000u32) >> 4  | (n_u & 0b00001111000011110000111100001111u32) << 4;
        n_u = (n_u & 0b11001100110011001100110011001100u32) >> 2  | (n_u & 0b00110011001100110011001100110011u32) << 2;
        n_u = (n_u & 0b10101010101010101010101010101010u32) >> 1  | (n_u & 0b01010101010101010101010101010101u32) << 1;

        // 3. Cast the final result back to i32 for the return type
        return n_u as i32;
    }
}





//oms





impl Solution {
    pub fn reverse_bits(mut n: i32) -> i32 {
        let mut reversed = 0;
        for _ in 0..32 {
            let bit = n & 1;
            n >>= 1;
            reversed <<= 1;
            reversed = reversed | bit;
        }
        reversed
    }
}






// This defines an 'implementation block' for a struct named 'Solution'. 
// It's a standard pattern for organizing methods in coding challenges.
impl Solution {

    // This declares a public function named 'reverse_bits'. 
    // It takes one argument 'n', marked 'mut' (mutable) so we can change it inside the function.
    // It expects an 'i32' (signed 32-bit integer) and returns an 'i32'.
    pub fn reverse_bits(mut n: i32) -> i32 {

        // Initializes a mutable variable 'reversed' to store the result. 
        // It starts at 0, inferred as an i32 type.
        let mut reversed = 0;

        // Starts a loop that executes exactly 32 times (once for each bit in the 32-bit integer).
        for _ in 0..32 {

            // Extracts the Least Significant Bit (LSB) from 'n' using a bitwise AND operation with 1.
            // If the last bit of 'n' is 1, 'bit' becomes 1; otherwise, 'bit' becomes 0.
            let bit = n & 1;

            // Shifts 'n' one position to the right, effectively dropping the LSB we just captured 
            // and moving the next bit into the LSB position for the next iteration.
            // (Note: In Rust/most C-like languages, this is an arithmetic shift for i32, which might introduce issues with negative numbers).
            n >>= 1;

            // Shifts the current 'reversed' result one position to the left, making an empty space 
            // at the LSB position to insert the new bit we found.
            reversed <<= 1;

            // Inserts the extracted 'bit' into the LSB of the 'reversed' variable using 
            // the bitwise OR operation.
            reversed = reversed | bit;

        // The loop finishes here after 32 iterations.
        }
        
        // Returns the final accumulated value in the 'reversed' variable. 
        // Rust automatically uses the last expression as the return value if there is no semicolon.
        reversed
    
    // The function definition ends here.
    }
// The implementation block ends here.
}

