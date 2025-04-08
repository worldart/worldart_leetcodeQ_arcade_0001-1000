//0ms

/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    let secondLast = 0;
    let last = 1;
    for (let i = 1; i <= n; i++) {
        let temp = last;
        last = secondLast + last;
        secondLast = temp;
    }
    return last;
};
