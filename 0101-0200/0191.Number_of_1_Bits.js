//0ms





/**
 * @param {number} n
 * @return {number}
 */
var hammingWeight = function(n) {
    let setBitCount = 0;
    while (n !== 0) {
        n &= (n - 1);
        setBitCount++;
    }
    return setBitCount;
};








//0ms






/**
 * @param {number} n
 * @return {number}
 */
var hammingWeight = function(n) {
    let result = 0;
    
    while (n > 0) {
        result += n % 2;
        n = Math.floor(n / 2);
    }
    
    return result;
};
