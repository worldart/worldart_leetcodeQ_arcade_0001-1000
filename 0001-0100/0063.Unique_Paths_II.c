//0ms 

int func(int i, int j, int** dp, int** grid, int m, int n);

// Main function to calculate unique paths with obstacles
int uniquePathsWithObstacles(int** obstacleGrid, int obstacleGridSize, int* obstacleGridColSize) {
    int m = obstacleGridSize;       // Number of rows
    int n = obstacleGridColSize[0]; // Number of columns

    // Edge case: If the grid is 1x1
    if (m == 1 && n == 1) {
        return (obstacleGrid[0][0] == 0) ? 1 : 0;
    }

    // Edge case: If the start or end cell is blocked
    if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
        return 0;
    }

    // Allocate memory for the DP table
    int** dp = (int**)malloc(m * sizeof(int*));
    for (int i = 0; i < m; i++) {
        dp[i] = (int*)malloc(n * sizeof(int));
        for (int j = 0; j < n; j++) {
            dp[i][j] = -1; // Initialize all values to -1 (unvisited)
        }
    }

    // Call the helper function
    int result = func(m - 1, n - 1, dp, obstacleGrid, m, n);

    // Free the allocated memory
    for (int i = 0; i < m; i++) {
        free(dp[i]);
    }
    free(dp);

    return result;
}

// Helper function to compute the number of paths using memoization
int func(int i, int j, int** dp, int** grid, int m, int n) {
    // Base case: Reached the starting cell
    if (i == 0 && j == 0) {
        return 1;
    }

    // Base case: Out of bounds
    if (i < 0 || j < 0) {
        return 0;
    }

    // Base case: Cell is blocked
    if (grid[i][j] == 1) {
        return 0;
    }

    // If the result is already computed, return it
    if (dp[i][j] != -1) {
        return dp[i][j];
    }

    // Recursive calls to compute paths from the left and top cells
    int left = func(i, j - 1, dp, grid, m, n);
    int up = func(i - 1, j, dp, grid, m, n);

    // Store the result in the DP table and return it
    dp[i][j] = left + up;
    return dp[i][j];
}
