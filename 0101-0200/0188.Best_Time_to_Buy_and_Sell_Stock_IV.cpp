//0ms





#include <stack>
#include <vector>
#include <utility>
#include <algorithm>
#include <numeric>
using std::stack;
using std::pair;
using std::vector;
using std::nth_element;
using std::accumulate;

class Solution {

public:
    int maxProfit(int k, const vector<int>& prices) {
        vector<int> profits;
        stack<pair<int, int>> vps;
        int v = 0;
        int p = -1;
        
        const int n = prices.size();
        for (;;) {
            for (v = p + 1; (v + 1) < n && prices[v] >= prices[v + 1]; ++v);
            for (p = v; (p + 1) < n && prices[p] <= prices[p + 1]; ++p);
            if (p == v) break;
            
            while (!vps.empty() && prices[vps.top().first] >= prices[v]) {
                auto vp = vps.top();
                profits.push_back(prices[vp.second] - prices[vp.first]);
                vps.pop();
            }
            while (!vps.empty() && prices[vps.top().second] <= prices[p]) {
                profits.push_back(prices[vps.top().second] - prices[v]);
                v = vps.top().first; //  (v1, p2)
                vps.pop();
            }
            vps.emplace(v, p);
        }
        while (!vps.empty()) {
            auto vp = vps.top(); vps.pop();
            profits.push_back(prices[vp.second] - prices[vp.first]);
        }
        if (k >= profits.size()) {
            return accumulate(profits.begin(), profits.end(), 0);
        } else {
            nth_element(profits.begin(), profits.end() - k, profits.end());
            return accumulate(profits.end() - k, profits.end(), 0);
        }
    }
};







//15ms







class Solution {
public:
    vector<vector<vector<int>>> dp;

    int profit(vector<int>& prices, int i, int isBuy, int k) {
        if (i == prices.size() || k == 0) return 0;

        if (dp[i][isBuy][k] != -1) return dp[i][isBuy][k];

        int a, b;
        if (isBuy) {
            a = profit(prices, i + 1, 1, k);
            b = profit(prices, i + 1, 0, k) - prices[i];
        } else {
            a = profit(prices, i + 1, 0, k);
            b = profit(prices, i + 1, 1, k - 1) + prices[i];
        }

        return dp[i][isBuy][k] = max(a, b);
    }

    int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        dp = vector<vector<vector<int>>>(n, vector<vector<int>>(2, vector<int>(k + 1, -1)));
        return profit(prices, 0, 1, k);
    }
};







//3ms







class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n,vector<int>(k+1,0));
        for(int j =1;j<k+1;j++){
            int best = -prices[0];
            for(int i =1;i<n;i++){
                dp[i][j] = max(dp[i-1][j],prices[i] + best);
                best = max(best,dp[i][j-1]-prices[i]);
            }
        }
        int result = 0;
        for(int i =0;i<k+1;i++){
            result = max(result,dp[n-1][i]);
        }
        return result;
    }
};







//7ms






class Solution {
public:
    int solve(vector<int>& prices,int ind,int buy,int k,vector<vector<vector<int>>>& dp){
        if(ind>=prices.size() || k==0) return 0;
        if(dp[ind][buy][k]!=-1)return dp[ind][buy][k];
        if(buy==1) return dp[ind][buy][k] =max(solve(prices,ind+1,buy,k,dp),solve(prices,ind+1,0,k,dp)-prices[ind]);
        else return dp[ind][buy][k]=max(solve(prices,ind+1,buy,k,dp),solve(prices,ind+1,1,k-1,dp)+prices[ind]);
    }
    int maxProfit(int k, vector<int>& prices) {
        int n=prices.size();
        //vector<vector<vector<int>>> dp(n+1,vector<vector<int>>(2,vector<int>(k+1,0)));
        vector<vector<int>> prev(2,vector<int>(k+1,0));
        vector<vector<int>> curr(2,vector<int>(k+1,0));
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int l=1;l<=k;l++){
                    if(buy==1)  curr[buy][l] =max(prev[buy][l],prev[0][l]-prices[ind]);
                    else curr[buy][l]=max(prev[buy][l],prev[1][l-1]+prices[ind]);
                }
            }
            prev=curr;
        }
        return prev[1][k];
    }
};
