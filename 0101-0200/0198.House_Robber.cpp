//0ma






class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();

        if (n == 1) {
            return nums[0];
        }

        vector<int> dp(n, 0);

        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];        
    }
};






//0ms






class Solution {
public:
    int rob(vector<int>& nums) {
        int size = nums.size();
        if (size == 0) {
            return 0;
        }
        vector<int> dp(size + 1);
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= size; i++) {
            dp[i] = max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }

        return dp[size];
    }
};
