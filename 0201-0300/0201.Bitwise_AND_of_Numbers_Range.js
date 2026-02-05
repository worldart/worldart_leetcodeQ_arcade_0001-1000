//6ms





/**
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var rangeBitwiseAnd = function(left, right) {
    // Calculate the common leftmost bits between left and right
    let shift = 0;
    while (left < right) {
        // Right shift both left and right to find common bits
        left >>= 1;
        right >>= 1;
        shift++;
    }
    // Left shift the common bits to the original position
    return left << shift;
};





//3ms






/**
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var rangeBitwiseAnd = function(left, right) {
    let shift_count = 0
    while (left != right) {
        left = left >> 1
        right = right >> 1
        shift_count++
    }
    return left << shift_count
};
