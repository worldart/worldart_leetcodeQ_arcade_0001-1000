//1ms





class Solution {
    static int solveTab(int[] prices,int k){
        int n=prices.length;

        int [][] curr = new int[2][k+2];
        int [][] next = new int[2][k+2];

        for(int index=n-1;index>=0;index--){
            for(int buy=1;buy>=0;buy--){
                for(int limit=1;limit<=k;limit++){
                    int profit=0;
                    if(buy==1){
                        int salekaro=prices[index]+next[0][limit-1];
                        int skipkaro=0+next[1][limit];
                        profit+=Math.max(salekaro,skipkaro);
                    }
                    else{
                        int buykaro=-prices[index]+next[1][limit];
                        int skipkaro=0+next[0][limit];
                        profit+=Math.max(buykaro,skipkaro);
                    }
                    curr[buy][limit]=profit;
                }
            }
            next=curr;
        }
        return next[0][k];
    }
    public int maxProfit(int k, int[] prices) {
        return solveTab(prices,k);
    }
}






//0ms






class Solution {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        int[] profits = new int[n];
        for (int i = 1; i <= k ; i++) {
            int max = Integer.MIN_VALUE;
            int profit = 0;
            for( int j = n-1; j >= 0; j--) {
                max = Math.max(max, profits[j]+prices[j]);
                profit = Math.max(profit, max-prices[j]);
                profits[j] = profit;
            }
        }
        return profits[0];
    }
}







//1ms







class Solution {
    public static int f(int i, int canBuy, int cap, int prices[], int n, int dp[][][]) {
        if (i == n || cap == 0)
            return 0;
        if (dp[i][canBuy][cap] != -1)
            return dp[i][canBuy][cap];

        int profit;
        if (canBuy == 0) { // can buy
            int buy = -prices[i] + f(i + 1, 1, cap, prices, n, dp);
            int dontBuy = 0 + f(i + 1, 0, cap, prices, n, dp);
            profit = Math.max(buy, dontBuy);
        } else { // can sell
            int sell = prices[i] + f(i + 1, 0, cap - 1, prices, n, dp);
            int dontSell = 0 + f(i + 1, 1, cap, prices, n, dp);
            profit = Math.max(sell, dontSell);
        }

        return dp[i][canBuy][cap] = profit;
    }

    public int maxProfit(int k,int[] prices) {
        int n = prices.length;
        int ahead[][] = new int[2][k+1];
        int curr[][] = new int[2][k+1];

        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int cap = 1; cap <= k; cap++) {
                    int profit;
                    if (canBuy == 0) { // Can Buy
                        int buy = -prices[i] + ahead[1][cap];
                        int dontBuy = 0 + ahead[0][cap];
                        profit = Math.max(buy, dontBuy);
                    } else { // Can Sell
                        int sell = prices[i] + ahead[0][cap - 1];
                        int dontSell = 0 + ahead[1][cap];
                        profit = Math.max(sell, dontSell);
                    }
                    curr[canBuy][cap] = profit;
                }
            }
            ahead=curr;
        }

        return ahead[0][k];
    }
}

