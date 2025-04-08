//41.52%RT

//Approach -3

class Solution {
    

    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();

        // Create two boolean arrays to store the matching results for the current and previous rows
        boolean[] prev = new boolean[m + 1];
        boolean[] cur = new boolean[m + 1];

        // Initialize the first element of prev as true
        prev[0] = true;

        // Iterate through p and s to fill the cur array
        for (int i = 1; i <= n; i++) {
            // Initialize the first element of cur based on whether p contains '*'
            cur[0] = isAllStars(p, i);
            for (int j = 1; j <= m; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    cur[j] = prev[j - 1]; // Characters match or '?' is encountered.
                } else {
                    if (p.charAt(i - 1) == '*') {
                        cur[j] = prev[j] || cur[j - 1]; // '*' matches one or more characters.
                    } else {
                        cur[j] = false; // Characters don't match, and p[i-1] is not '*'.
                    }
                }
            }
            // Update prev array to store the current values
            prev = cur.clone();
        }

        return prev[m]; // The final result indicates whether p matches s.
    }
    
    private boolean isAllStars(String p, int i) {
        for (int j = 1; j <= i; j++) {
            if (p.charAt(j - 1) != '*') {
                return false;
            }
        }
        return true;
    }
}
