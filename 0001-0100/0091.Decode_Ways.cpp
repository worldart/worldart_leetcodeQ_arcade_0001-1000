//0ms


class Solution {
public:
    
    int dp[102];
    int decode(string& s, int idx, int n)
    {
        if(idx < n && s[idx] == '0') return 0;
        if(idx >= n)
            return 1;
        
        if(dp[idx] != -1) return dp[idx];
        
        int ways = 0;
        
        // Pick single
        if(s[idx] != '0') ways = decode(s, idx+1, n);
            
        // Pick couple
        if(idx+1 < n && ((s[idx] == '1' && s[idx+1] <= '9') || (s[idx]=='2' && s[idx+1] < '7')))
           ways += decode(s, idx+2, n);
           
        return dp[idx] = ways;
    }
    
    int numDecodings(string s) {
       
        int n = s.size();
        memset(dp, -1, sizeof(dp));
        return decode(s, 0, n);
    }
};



/*

class Solution {
public:
    int numDecodings(string s) {
        int n = s.size();
        vector<int> dp(n+1, 0);
        dp[n] = 1;
        for (int i = n - 1; i >= 0; --i) {
            if (s[i] != '0') dp[i] += dp[i+1];
            if (i+1 < s.size() && (s[i] == '1' || s[i] == '2' && s[i+1] <= '6'))
                dp[i] += dp[i+2];
        }
        return dp[0];
    }
};
*/
