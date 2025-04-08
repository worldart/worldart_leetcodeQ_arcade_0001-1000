//94.54%RT

class Solution {
public:
    bool isMatch(string s, string p) {
        return isMatch(s.c_str(), p.c_str());
    }

private:
    bool isMatch(const char *s, const char *p) {
        const char* star = nullptr; // Track the position of the last '*' encountered
        const char* ss = s; // Track the position of the string before the last '*'

        while (*s) { // Loop until the end of the string
            // Advance both pointers if the characters match or '?' is found in the pattern
            if ((*p == '?') || (*p == *s)) {
                s++;
                p++;
                continue;
            }

            // If '*' is found in the pattern, track its position and advance the pattern pointer
            if (*p == '*') {
                star = p++;
                ss = s;
                continue;
            }

            // If the characters don't match, but a '*' was previously encountered, backtrack to the '*'
            if (star) {
                p = star + 1;
                s = ++ss;
                continue;
            }

            // If the characters don't match and no '*' was previously encountered, it's a mismatch
            return false;
        }

        // Check for remaining '*' characters in the pattern
        while (*p == '*') {
            p++;
        }

        // Return true if all characters in the pattern have been matched
        return !*p;
    }
};
