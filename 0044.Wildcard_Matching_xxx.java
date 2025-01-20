//31.28%RT



// Approach -2

class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();

        // Create a 2D array to store the matching results
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        // Initialize the first row and column based on wildcard '*' in p
        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = isAllStars(p, i);
        }

        // Fill the dp array using a bottom-up approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match or '?' is encountered.
                } else {
                    if (p.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // '*' matches one or more characters.
                    } else {
                        dp[i][j] = false; // Characters don't match, and p[i-1] is not '*'.
                    }
                }
            }
        }

        return dp[n][m]; // The final result indicates whether p matches s.
    }

    private boolean isAllStars(String p, int i) {
        for (int j = 1; j <= i; j++) {
            if (p.charAt(j - 1) != '*')
                return false;
        }
        return true;
    }
}
