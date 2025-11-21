#42ms




class Solution:
    def reverseBits(self, n: int) -> int:
        result = 0
        for _ in range(32):
            result = (result << 1) | (n & 1)
            n >>= 1
        return result
      





class Solution:
    def reverseBits(self, n: int) -> int:
        # Initialize result to 0 — this will store the reversed bit pattern
        result = 0
        
        # Loop exactly 32 times because we are working with 32-bit unsigned integers
        for _ in range(32):
            
            # (n & 1) extracts the least significant bit (LSB) of n
            # result << 1 shifts result left by 1 bit to make room for the new bit
            # OR operation combines them, adding the extracted bit to result
            result = (result << 1) | (n & 1)
            
            # Shift n right by 1 to process the next bit in the next iteration
            n >>= 1
        
        # Return the final reversed integer
        return result


'''

| Component             | Role                                                              |                                           |
| --------------------- | ----------------------------------------------------------------- | ----------------------------------------- |
| `result = 0`          | Stores the reversed bits as they are built                        |                                           |
| `for _ in range(32):` | Ensures processing of all 32 bits regardless of leading zeros     |                                           |
| `n & 1`               | Extracts the current least significant bit                        |                                           |
| `result << 1`         | Shifts previously stored bits left to make space for the next bit |                                           |
| `                     | `                                                                 | Inserts the extracted bit into the result |
| `n >>= 1`             | Moves to the next bit of the input number                         |                                           |
| `return result`       | Outputs the reversed 32-bit pattern                               |                                           |


'''


#38ms




class Solution:
    def reverseBits(self, n: int) -> int:
        return int(
            (
                bin(n)[2:].zfill(32)    # Convert n to binary string, drop the '0b' prefix, and pad with leading zeros to make it 32 bits
            )[::-1],                    # Reverse the 32-bit binary string
            2                            # Convert the reversed binary string back to an integer (base 2)
        )






'''



| Part          | Role                                                                          |
| ------------- | ----------------------------------------------------------------------------- |
| `bin(n)`      | Converts integer `n` to a binary string (e.g., `"0b101010"`).                 |
| `[2:]`        | Removes the `"0b"` prefix so only bits remain.                                |
| `.zfill(32)`  | Pads the string with leading zeros to ensure it has exactly 32 bits.          |
| `[::-1]`      | Reverses the 32-bit binary string.                                            |
| `int(..., 2)` | Converts the reversed binary string back to an integer using base-2 notation. |




'''





#37ms






class Solution:
    def reverseBits(self, n: int) -> int:
        x = 0
        for i in range(32):
            if (n >> i) & 1:
                x = x | (1 << (31 - i))
            else:
                x = x & ~(1 << (31 - i))
        return x






class Solution:
    def reverseBits(self, n: int) -> int:
        # x will store the final reversed 32-bit result
        x = 0
        
        # Loop through all 32 bit positions (i = 0 is LSB, i = 31 is MSB)
        for i in range(32):
            
            # Check whether the i-th bit of n is 1
            if (n >> i) & 1:
                # If the i-th bit of n is 1:
                # Set the (31 - i) th bit of x to 1
                x = x | (1 << (31 - i))
            else:
                # If the i-th bit of n is 0:
                # Clear the (31 - i) th bit of x (even though it is already 0 initially)
                x = x & ~(1 << (31 - i))
        
        # After all 32 bits are processed, return the reversed result
        return x



'''


| Component            | Role                                                     |
| -------------------- | -------------------------------------------------------- |
| `x = 0`              | Stores the output bits in reversed order                 |
| `for i in range(32)` | Iterates through every bit position of the 32-bit number |
| `(n >> i) & 1`       | Reads the bit at position `i` of `n`                     |
| `1 << (31 - i)`      | Computes the symmetric reversed bit position             |
| `x = x \| (...)`     | Sets a specific bit of `x` to `1`                        |
| `x = x & ~(...)`     | Clears a specific bit of `x` (forces it to `0`)          |
| `return x`           | Returns the final reversed 32-bit integer                |



'''






#37ms






class Solution:
    def reverseBits(self, n: int) -> int:
        val = format(n, "032b")
        val = val[::-1]
        op = int(val, 2)
        return op





class Solution:
    def reverseBits(self, n: int) -> int:
        # Convert n to a 32-bit binary string (padding with leading zeros if necessary)
        val = format(n, "032b")
        
        # Reverse the 32-bit binary string
        val = val[::-1]
        
        # Convert the reversed binary string back to an integer (base 2)
        op = int(val, 2)
        
        # Return the final reversed integer
        return op





'''

| Component           | Role                                                                                 |
| ------------------- | ------------------------------------------------------------------------------------ |
| `format(n, "032b")` | Converts integer `n` to a binary string of exactly 32 bits (zero-padded)             |
| `[::-1]`            | Reverses the binary string                                                           |
| `int(val, 2)`       | Converts the reversed binary string back into an integer using base-2 representation |
| `return op`         | Outputs the final reversed 32-bit integer                                            |




'''






#45ms






class Solution:
    def reverseBits(self, n: int) -> int:
        resultado = 0
        for _ in range(32):
            bit = n & 1
            n >>= 1
            resultado <<= 1
            resultado |= bit
        return resultado




class Solution:
    def reverseBits(self, n: int) -> int:
        # resultado will store the reversed bit pattern as it is constructed
        resultado = 0
        
        # Loop exactly 32 times because we are working with a 32-bit unsigned integer
        for _ in range(32):
            
            # Extract the least significant bit (LSB) from n
            bit = n & 1
            
            # Shift n to the right by 1 to move to the next bit for the next iteration
            n >>= 1
            
            # Shift resultado left by 1 to make space for the new bit being added
            resultado <<= 1
            
            # Add the extracted bit to resultado
            resultado |= bit
        
        # Return the final reversed integer after all 32 bits were processed
        return resultado




'''


| Component            | Role                                                          |                                                                              |
| -------------------- | ------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| `resultado = 0`      | Stores the reversed bits of `n` as they are built             |                                                                              |
| `for _ in range(32)` | Ensures all 32 bits are processed even if leading zeros exist |                                                                              |
| `bit = n & 1`        | Extracts the current least significant bit from `n`           |                                                                              |
| `n >>= 1`            | Moves to the next bit of `n` by shifting right                |                                                                              |
| `resultado <<= 1`    | Shifts stored bits left to prepare for the next inserted bit  |                                                                              |
| `resultado           | = bit`                                                        | Inserts the extracted bit into the least significant position of `resultado` |
| `return resultado`   | Outputs the 32-bit reversed result                            |                                                                              |




'''

