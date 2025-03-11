//0ms

class Solution {
private:
   bool DP_helper(string &s1, string &s2, int idx1, int idx2, int len, char isS[]) {
        int sSize = s1.size(), i, j, k, hist[26], zero_count = 0;

        // Check if we have already computed the result for this substring pair
        if (isS[(len * sSize + idx1) * sSize + idx2]) {
            return isS[(len * sSize + idx1) * sSize + idx2] == 1;
        }

        bool res = false;

        // Count the frequency of each character in the two substrings
        fill_n(hist, 26, 0);
        for (k = 0; k < len; ++k) {
            zero_count += (0 == hist[s1[idx1 + k] - 'a']) - (0 == ++hist[s1[idx1 + k] - 'a']);
            zero_count += (0 == hist[s2[idx2 + k] - 'a']) - (0 == --hist[s2[idx2 + k] - 'a']);
        }

        // If the two substrings have different characters, return false
        if (zero_count) {
            isS[(len * sSize + idx1) * sSize + idx2] = 2;
            return false;
        }

        // If the length of the substrings is 1, return true
        if (len == 1) {
            isS[(len * sSize + idx1) * sSize + idx2] = 1;
            return true;
        }

        // Recursively check all possible split positions
        for (k = 1; k < len && !res; ++k) {
            res = res || (DP_helper(s1, s2, idx1, idx2, k, isS) && DP_helper(s1, s2, idx1 + k, idx2 + k, len - k, isS));
            res = res || (DP_helper(s1, s2, idx1 + len - k, idx2, k, isS) && DP_helper(s1, s2, idx1, idx2 + k, len - k, isS));
        }

        // Save the intermediate result in the cache
        isS[(len * sSize + idx1) * sSize + idx2] = res ? 1 : 2;
        return res;
    }

public:
    bool isScramble(string s1, string s2) {
        const int sSize = s1.size();

        // Base case: empty strings are always valid scrambles of each other
        if (0 == sSize) {
            return true;
        }

        // Initialize the cache
        char isS[(sSize + 1) * sSize * sSize];
        fill_n(isS, (sSize + 1) * sSize * sSize, 0);

        // Recursively check if s1 and s2 are valid scrambles of each other
        return DP_helper(s1, s2, 0, 0, sSize, isS);
    }
};
