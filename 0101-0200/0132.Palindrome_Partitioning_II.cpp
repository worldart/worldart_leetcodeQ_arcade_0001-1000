//63ms


class Solution {
public:
    // bool isPalindrome(string s){
    //     for(int i=0;i<s.size()/2+1;i++){
    //         if(s[i]!=s[s.size()-i-1]) return false;
    //     }
    //     return true;
    // }
    int f(int i,int n,string &s,vector<int> &dp,vector<vector<int>> &palin){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        int mn=1e9;
        for(int j=i;j<n;j++){
            if(palin[i][j]){
                int cost=1+f(j+1,n,s,dp,palin);
                mn=min(cost,mn);
            }
        }
        return dp[i]=mn;
    }
    int minCut(string s) {
        ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
        //if(isPalindrome(s)) return 0;
        int n=s.size();
        vector<vector<int>> palin(n,vector<int> (n,0));
        for(int i=n-1;i>=0;i--) 
        for(int j=i;j<n;j++) if(s[i]==s[j] && (j-i<2 || palin[i+1][j-1])) palin[i][j]=1; 

        vector<int> dp(n,-1);
        return f(0,n,s,dp,palin)-1;
    }
};


//27ms



class Solution {
public:
    int minCut(string s) {
        int n = s.length();
        vector<vector<bool>> isPal(n, vector<bool>(n, false));
        vector<int> minCuts(n, 0);
        
        for (int i = 0; i < n; i++) {
            minCuts[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s[i] == s[j] && (i - j <= 2 || isPal[j+1][i-1])) {
                    isPal[j][i] = true;
                    if (j == 0)
                        minCuts[i] = 0;
                    else
                        minCuts[i] = min(minCuts[i], minCuts[j-1] + 1);
                }
            }
        }
        
        return minCuts[n - 1];
    }
};
