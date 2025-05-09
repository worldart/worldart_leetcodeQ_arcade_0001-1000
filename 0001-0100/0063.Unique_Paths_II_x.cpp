//0ms

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& grid) {
	int m = size(grid), n = size(grid[0]);
	vector<vector<int> > dp (2, vector<int>(n + 1));
    dp[0][1] = 1;
    for(int i = 1; i <= m; i++)
        for(int j = 1; j <= n; j++)            
            dp[i & 1][j] = !grid[i - 1][j - 1] ? dp[(i - 1) & 1][j] + dp[i & 1][j - 1] : 0;
    return dp[m & 1][n];
}};
    
