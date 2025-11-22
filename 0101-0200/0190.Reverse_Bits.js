//45ms





/**
 * @param {number} n
 * @return {number}
 */
var reverseBits = function(n) {
    let result = 0;
    for (let i = 0; i < 32; i++) {
        result = (result << 1) | (n & 1);
        n >>>= 1;
    }
    return result >>> 0;
};







/**
 * @param {number} n
 * @return {number}
 */
var reverseBits = function(n) {
    let result = 0;               // This will store the reversed bits

    for (let i = 0; i < 32; i++) {  
        // Shift result left to make space for the next bit
        // OR with the last bit of n to append that bit to result
        result = (result << 1) | (n & 1);

        // Unsigned right shift n to process the next bit
        n >>>= 1;
    }

    // Force result to be interpreted as an unsigned 32-bit integer
    return result >>> 0;
};





//40ms







/**
 * @param {number} n
 * @return {number}
 */
var reverseBits = function(n) {
    let res = 0;
    for (let i = 0; i < 32; i++) {
        res = (res << 1) + (n & 1);
        n >>= 1;
    }
    return res;
};







/**
 * @param {number} n
 * @return {number}
 */
var reverseBits = function(n) {
    let res = 0;                         // This will accumulate the reversed bits

    for (let i = 0; i < 32; i++) {       // Loop through all 32 bits
        // Shift res left by 1 to make room for the next bit,
        // then add the least significant bit of n (n & 1)
        res = (res << 1) + (n & 1);

        // Right-shift n by 1 (signed shift),
        // discarding the bit we just used
        n >>= 1;
    }

    // Return the reversed bit sequence
    return res;
};







//48ms







/**
 * @param {number} n
 * @return {number}
 */
var reverseBits = function(n) {
    const binary = n.toString(2).padStart(32,0).split('').reverse().join('');
    return parseInt(binary, 2);
};







/**
 * @param {number} n
 * @return {number}
 */
var reverseBits = function(n) {
    // Convert n to a binary string (base 2),
    // pad it to 32 bits with leading zeros,
    // split into an array of characters,
    // reverse the array,
    // and join it back into a reversed 32-bit binary string.
    const binary = n.toString(2).padStart(32, 0).split('').reverse().join('');

    // Convert the reversed binary string back into a number
    return parseInt(binary, 2);
};





