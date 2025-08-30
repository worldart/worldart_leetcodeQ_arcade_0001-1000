//0ms





impl Solution {
  // Find the minimum initial health for the knight to be able to rescue the princess.
  pub fn calculate_minimum_hp(dungeon: Vec<Vec<i32>>) -> i32 {
    let m = dungeon.len();
    let n = dungeon[0].len();
    let mut dp = vec![vec![0; n]; m];

    // Start from the princess cell
    dp[m - 1][n - 1] = (1 - dungeon[m - 1][n - 1]).max(1);

    // Fill the last row
    for j in (0..n - 1).rev() {
      dp[m - 1][j] = (dp[m - 1][j + 1] - dungeon[m - 1][j]).max(1);
    }

    // Fill the last column
    for i in (0..m - 1).rev() {
      dp[i][n - 1] = (dp[i + 1][n - 1] - dungeon[i][n - 1]).max(1);
    }

    // Fill the rest of the dp table
    for i in (0..m - 1).rev() {
      for j in (0..n - 1).rev() {
        let min_health_on_exit = dp[i + 1][j].min(dp[i][j + 1]);
        dp[i][j] = (min_health_on_exit - dungeon[i][j]).max(1);
      }
    }

    // The minimum initial health required to reach the princess
    dp[0][0]

  }
}





//0ms







impl Solution {
    pub fn calculate_minimum_hp(dungeon: Vec<Vec<i32>>) -> i32 {
        let m = dungeon.len();
        let n = dungeon[0].len();
        let inf = i32::MAX / 4;
        let mut dp = vec![vec![inf; n + 1]; m + 1];
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;

        for i in (0..m).rev() {
            for j in (0..n).rev() {
                let need = dp[i + 1][j].min(dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = if need <= 1 { 1 } else { need };
            }
        }
        dp[0][0]
    }
}
