

Step 1: Express the problem in terms of indices i and j.
Let f(i, j) represent the number of distinct subsequences of s1[0..i] that match s2[0..j].
s1 is the larger string (size n), and s2 is the smaller string (size m).
i goes from 0 to n-1 for s1.
j goes from 0 to m-1 for s2.
Step 2: Explore all possibilities.
When comparing s1[i] and s2[j], two cases arise:

If characters match (s1[i] == s2[j]):

We have two choices:

Choose: Include the matching character from s1. This gives f(i-1, j-1).
Leave: Ignore the character in s1 and move to the next character. This gives f(i-1, j).
Formula:
f(i,j)=f(i−1,j−1)+f(i−1,j)
If characters don’t match (s1[i] != s2[j]):

Skip the current character of s1 and move to the next character.
Formula:
f(i,j)=f(i−1,j)
Step 3: Write the base cases.
If s2 is exhausted (j < 0):

We have successfully matched all characters of s2.
Return 1.
If s1 is exhausted (i < 0) but s2 is not:

There is no way to match s2.
Return 0.



Approach 1 : Recursive Approach
Explore all subsequences by recursively including/excluding characters. Base cases handle when t is fully matched or s is exhausted. This brute force approach has exponential time complexity.

Complexity
Time complexity:O(2 
n
 +2 
m
 )
Space complexity:O(n+m)

(TO)

class Solution {
    int solve(int index1,int index2,string &str1,string &str2){
        if(index2<0){
            return 1;
        }
        if(index1<0){
            return 0;
        }
        if(str1[index1]==str2[index2]){
            return solve(index1-1,index2-1,str1,str2)+solve(index1-1,index2,str1,str2);
        }
        return solve(index1-1,index2,str1,str2);
    }
public:
    int numDistinct(string s, string t) {
        int n1=s.size();
        int n2=t.size();
        return solve(n1-1,n2-1,s,t);
    }
};





Approach 2 : Memoization Approach
Use recursion with a memoization table (dp) to avoid redundant computations. Store results of overlapping subproblems, significantly reducing time complexity to polynomial.

Complexity
Time complexity:O(n∗m)
Space complexity:O(n+m)[Recursive Stack Space]+O(n∗m)[Dp Array]

(TO)

class Solution {
    int solve(int index1,int index2,string &str1,string &str2,vector<vector<int>> &dp){
        if(index2<0){
            return 1;
        }
        if(index1<0){
            return 0;
        }
        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }
        if(str1[index1]==str2[index2]){
            return solve(index1-1,index2-1,str1,str2,dp)+solve(index1-1,index2,str1,str2,dp);
        }
        return dp[index1][index2]=solve(index1-1,index2,str1,str2,dp);
    }
public:
    int numDistinct(string s, string t) {
        int n1=s.size();
        int n2=t.size();
        vector<vector<int>> dp(n1+1,vector<int>(n2+1,-1));
        return solve(n1-1,n2-1,s,t,dp);
    }
};



Approach 3 : Tabulation Approach
Iteratively fill a 2D DP table. Each cell represents subsequences count matching prefixes of s and t, building results bottom-up for clarity and efficiency.

Complexity
Time complexity:O(n∗m)
Space complexity:O(n∗m)[Dp Array]


//31ms

class Solution {
public:
    int numDistinct(string s, string t) {
        int n1=s.size();
        int n2=t.size();
        vector<vector<double>> dp(n1+1,vector<double>(n2+1,0));
        for(int i=0;i<n1+1;i++)  dp[i][0]=1;
        for(int i=1;i<n1+1;i++){
            for(int j=1;j<n2+1;j++){
                if(s[i-1]==t[j-1]){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return int(dp[n1][n2]);
    }
};



Approach 4 : Space Optimization
Optimize tabulation by reducing the 2D DP table to two 1D arrays (prev and curr), representing the current and previous rows, minimizing space usage while maintaining functionality.

Complexity
Time complexity:O(n∗m)
Space complexity:O(m+m)


//11ms

class Solution {
public:
    int numDistinct(string s, string t) {
        int n1=s.size();
        int n2=t.size();
        vector<double> prev(n2+1,0),curr(n2+1,0);
        prev[0]=curr[0]=1;
        for(int i=1;i<n1+1;i++){
            for(int j=1;j<n2+1;j++){
                if(s[i-1]==t[j-1]){
                    curr[j]=prev[j-1]+prev[j];
                }
                else{
                    curr[j]=prev[j];
                }
            }
            prev=curr;
        }
        return int(prev[n2]);
    }
};


Approach 5 : Even More Space Optimization (1d Array)
Reduce space further by using a single 1D array (prev). Iterate over t in reverse order to preserve dependency, maintaining correctness with minimal memory overhead.

//10ms

Complexity
Time complexity:O(n∗m)
Space complexity:O(m)



class Solution {
public:
    int numDistinct(string s, string t) {
        int n1=s.size();
        int n2=t.size();
        vector<double> prev(n2+1,0);
        prev[0]=1;
        for(int i=1;i<n1+1;i++){
            for(int j=n2;j>=1;j--){
                if(s[i-1]==t[j-1]){
                    prev[j]=prev[j-1]+prev[j];
                }
            }
        }
        return int(prev[n2]);
    }
};
