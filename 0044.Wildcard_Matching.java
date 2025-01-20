//95.27%RT

class Solution {
    public boolean isMatch(String s, String p) {
        return comparison(s, p);
    }

    boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;

        // Loop through the string and pattern
        while (s < str.length()) {
            // If the current characters match or the pattern character is '?'
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            // If the current pattern character is '*'
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                // Save the position of the '*' and the current string position
                starIdx = p;
                match = s;
                p++;
            }
            // If the last pattern character was '*'
            else if (starIdx != -1) {
                // Advance the pattern pointer to after the '*'
                p = starIdx + 1;
                // Advance the string pointer to after the matched characters
                match++;
                s = match;
            }
            // If the current pattern character is not '*' and the last pattern character was not '*',
            // and the characters do not match
            else {
                return false;
            }
        }

        // Check for remaining '*' characters in the pattern
        while (p < pattern.length() && pattern.charAt(p) == '*') {
            p++;
        }

        // Return true if all characters in the pattern have been matched
        return p == pattern.length();
    }
}
