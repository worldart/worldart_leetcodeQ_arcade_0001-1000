//0ms






/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    const n = nums.length;

    if (n === 1) {
        return nums[0];
    }

    const dp = Array(n).fill(0);

    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (let i = 2; i < n; i++) {
        dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
    }

    return dp[n - 1];    
};





//0ms






/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    const map = new Map([
        [0, 0],
        [1, nums[0]],
        [2, Math.max(nums[0], nums[1])]
    ]);
    const dp = nums => {
        if (map.has(nums.length)) return map.get(nums.length);
        const ans = Math.max(
            dp(nums.slice(0, nums.length - 2)) + nums[nums.length - 1],
            dp(nums.slice(0, nums.length - 1))
        );
        map.set(nums.length, ans);
        return ans;
    }
    return dp(nums);
};
