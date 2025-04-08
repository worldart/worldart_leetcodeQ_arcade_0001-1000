//0ms

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int i,j,m=grid.size(),n=grid[0].size();
        for(i = 1; i < n; i++){
            grid[0][i] += grid[0][i-1];
        }
        for(j = 1; j < m; j++){
            grid[j][0] += grid[j-1][0];
        }
        for(i = 1; i < m; i++){
            for(j = 1; j < n; j++){
                grid[i][j] += min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
};
