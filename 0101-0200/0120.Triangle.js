//0ms

/**
 * @param {number[][]} triangle
 * @return {number}
 */
function minimumTotal(triangle) {
    const n = triangle.length;
    const dp = [...triangle[n - 1]]; // start with the last row

    // Move from second-last row up to the top
    for (let i = n - 2; i >= 0; i--) {
        for (let j = 0; j <= i; j++) {
            dp[j] = triangle[i][j] + Math.min(dp[j], dp[j + 1]);
        }
    }

    return dp[0];
}
