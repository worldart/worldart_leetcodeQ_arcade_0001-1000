//54ms


class Solution {
public:
    vector<vector<string>> partition(string s) {
        // backtracking 
        // 1. define `ans` to hold `candidates`
        vector<vector<string>> ans;
        // 2. define `candidates` to hold all potential candidates (palindromic substring)
        vector<string> candidates;
        // 3. start backtrack from index 0
        backtrack(s, ans, candidates, 0);
        // 4. return ans
        return ans;
    }
    
     void backtrack(string s, vector<vector<string>>& ans, vector<string>& candidates, int start) {
        // 1. check if the goal is fulfilled, 
        // i.e. reaching the end of string in this problem
        if (start == s.size()) {
            // if so, we push `candidates` to ans since we've processed all characters
            ans.push_back(candidates);
            return;
        }
        // 2. find all potential candidates
        for (int i = start; i < s.size(); i++) {
            // we want to test all substrings, each substring is a potential candidate
            // e.g. "aab" -> "a", "a", "b", "ab", "aa", "b", "aab"
            string candidate = s.substr(start, i - start + 1);
            // 3. check if the current candidate is palindrome or not 
            // if not, then we cannot push to `candidates`
            if(!is_palindrome(candidate)) continue;
            // 4. if so, push it to candidates
            candidates.push_back(candidate);
            // 5. backtrack with index + 1
            backtrack(s, ans, candidates, i + 1);
            // 6. remove the current substring from `candidates`
            candidates.pop_back();
        }
    }
    
    
    // there are different ways to check if `s` is palindrome 
    // here's my favourite one
    bool is_palindrome(string s) {
        return equal(s.begin(), s.begin() + s.size() / 2, s.rbegin());
    }
};




//31ms




#include <vector>
#include <string>

using namespace std;

class Solution {
private:
    // Builds a table where table[i][j] is true if s[i:j] is a palindrome
    inline vector<vector<bool>> build_palindrome_table(const string& s) {
        size_t n {s.size()};
        vector<vector<bool>> table(n, vector<bool>(n, false));
        
        // Single characters are palindromes
        for (size_t i {0}; i < n; ++i) {
            table[i][i] = true;
        }
        
        // Check palindromes of length 2 and greater
        for (size_t len {2}; len <= n; ++len) {
            for (size_t start {0}; start <= n - len; ++start) {
                size_t end {start + len - 1};

                // A substring s[start:end] is a palindrome if:
                // The first and last characters match: s[start] == s[end].
                // The inner substring s[start+1:end-1] is a palindrome (checked via table[start+1][end-1]).
                // Special case for len == 2: If s[start] == s[end], it’s a palindrome (e.g., "aa"), so no need to check the inner substring (which would be empty).
                // The condition len == 2 || table[start + 1][end - 1] handles this efficiently.                
                if (s[start] == s[end] && (len == 2 || table[start + 1][end - 1])) {
                    table[start][end] = true;
                }
            }
        }
        return table;
    }

    // Checks if s[left:right] is a palindrome using the precomputed table
    inline bool is_palindrome(const string& s, size_t left, size_t right, const vector<vector<bool>>& table) {
        return table[left][right];
    }

    inline void partition_string(const string& s, size_t left, size_t right, 
                                vector<vector<string>>& result, vector<string>& partition, 
                                const vector<vector<bool>>& table) {
        if (left > right) {
            result.push_back(partition);
            return;   
        }

        for (size_t i {left}; i <= right; ++i) {
            if (is_palindrome(s, left, i, table)) {
                partition.push_back(s.substr(left, i - left + 1));
                partition_string(s, i + 1, right, result, partition, table);
                partition.pop_back();
            }
        }
    }

public:
    vector<vector<string>> partition(const string& s) {
        vector<vector<string>> result;
        vector<string> partition;
        partition.reserve(s.size());
        vector<vector<bool>> palindrome_table {build_palindrome_table(s)};

        partition_string(s, 0, s.size() - 1, result, partition, palindrome_table);

        return result;
    }
};





//34ms





class Solution {
private:
    vector<vector<bool>> dp;
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> answer;
        vector<string> cur_partition;
        dp = vector<vector<bool>>(s.size(), vector<bool>(s.size(), false));
        isPalindrome(s);
        generatePartitions(s, 0, answer, cur_partition);

        return answer;
    }

    void generatePartitions(string& s, int left, auto& answer, auto& cur_partition) {
        if (left == s.size()) {
            answer.push_back(cur_partition);
            return;
        }
        
        for (int i = left; i < s.size(); i++) {
            if (dp[left][i]) {
                cur_partition.push_back(s.substr(left, i - left + 1));
                generatePartitions(s, i + 1, answer, cur_partition);
                cur_partition.pop_back();
            }
        }
    }

    void isPalindrome(string& s) {
        int n = s.size();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j - i >= 2 && s[i] == s[j] && dp[i + 1][j - 1])
                    dp[i][j] = true;
                else if (j - i < 2 && s[i] == s[j])
                    dp[i][j] = true;
            }
        }
    }
};
