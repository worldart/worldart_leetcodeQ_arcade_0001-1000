//0ms






/**
 * @param {number} n
 * @return {number}
 */
var trailingZeroes = function(n) {
    var count  = 0, multiple = 5
    while(multiple <= n) {
        count += Math.floor(n/multiple)
        multiple *= 5
    }
    return count

};






//0ms






/**
 * @param {number} n
 * @return {number}
 */
var trailingZeroes = function(n) {
    let result = 0;
    for(let i=5;i <= n ;i=i*5){
        result = result + Math.floor(n/i)
    }
    return result
};
