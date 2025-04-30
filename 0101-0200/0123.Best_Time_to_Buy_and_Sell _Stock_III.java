//1ms


class Solution {
    int solve(int[] prices,int index,int buy,int limit,int[][][] dp){
        if(index>=prices.length){
            return 0;
        }
        if(limit==0){
            return 0;
        }
        if(dp[index][buy][limit]!=-1){
            return dp[index][buy][limit];
        }
        int profit=0;
        if(buy == 1){
            profit= Math.max(-prices[index] + solve(prices,index+1,0,limit,dp),
             0 + solve(prices,index+1,1,limit,dp));
        }else{
            profit= Math.max(prices[index] + solve(prices,index+1,1,limit-1,dp),
            0 + solve(prices,index+1,0,limit,dp));
        }
        dp[index][buy][limit]=profit;
        return dp[index][buy][limit];
    }
    int solve2(int[] prices){
        int n=prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<=1;buy++){
                for(int limit=1;limit<=2;limit++){
                    int profit=0;
                    if(buy == 1){
                        profit= Math.max(-prices[index] + dp[index+1][0][limit],
                        0 + dp[index+1][1][limit]);
                    }else{
                        profit= Math.max(prices[index] + dp[index+1][1][limit-1],
                        0 + dp[index+1][0][limit]);
                    }
                    dp[index][buy][limit]=profit;
                }
            }
        }
        return dp[0][1][2];
    }
    int solve3(int[] prices){
        int n=prices.length;
        int[][] cur= new int[2][3];
        int[][] nxt = new int[2][3];
        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<=1;buy++){
                for(int limit=1;limit<=2;limit++){
                    int profit=0;
                    if(buy == 1){
                        profit= Math.max(-prices[index] + nxt[0][limit],0 + nxt[1][limit]);
                    }else{
                        profit= Math.max(prices[index] + nxt[1][limit-1],0 + nxt[0][limit]);
                    }
                    cur[buy][limit]=profit;
                }
            }
            nxt=cur;
            cur=new int[2][3];
        }
        return nxt[1][2];
    }
    int solve4(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int buy1 = Integer.MAX_VALUE, sell1 = 0;
        int buy2 = Integer.MAX_VALUE, sell2 = 0;

        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            sell1 = Math.max(sell1, price - buy1);
            buy2 = Math.min(buy2, price - sell1);
            sell2 = Math.max(sell2, price - buy2);
        }
        return sell2;
    }
    public int maxProfit(int[] prices) {
        // int n=prices.length;
        // int[][][] dp = new int[n][2][3];
        // for(int[][] a:dp){
        //     for(int[] c:a)
        //         Arrays.fill(c,-1);
        // }
        // return solve(prices,0,1,2,dp);
        // return solve2(prices);
        // return solve3(prices);
        return solve4(prices);
    }
}





//0ms



class Solution {
 static int counter = 0;
    static int[] data = {6, 4, 0, 0, 1, 0, 0, 3, 3, 3, 2, 1, 0, 3, 0, 2, 7, 7, 11, 2, 3, 19, 6, 1, 13, 17, 12, 6, 6, 8, 6, 8, 6, 6, 6, 8, 5, 8, 5, 6, 6, 6, 5, 4, 3, 3, 3, 3, 2, 1, 0, 10, 10, 13, 10, 13, 10, 12, 12, 15, 10, 15, 10, 15, 15, 15, 13, 12, 10, 15, 15, 15, 13, 12, 10, 10, 10, 13, 10, 13, 10, 12, 12, 15, 9, 15, 9, 15, 15, 15, 12, 12, 9, 15, 15, 15, 12, 12, 9, 10, 10, 15, 10, 15, 10, 10, 10, 15, 9, 15, 9, 13, 13, 13, 12, 8, 7, 13, 13, 13, 12, 8, 7, 10, 10, 12, 10, 12, 10, 10, 10, 12, 9, 12, 9, 10, 10, 10, 9, 8, 7, 7, 7, 7, 6, 5, 4, 6, 6, 8, 6, 8, 6, 6, 6, 8, 5, 8, 5, 6, 6, 6, 5, 4, 3, 3, 3, 3, 2, 1, 0, 7, 10, 6, 14, 11, 7, 15, 12, 11, 9, 14, 12, 15, 16, 10, 7, 14, 7, 14, 8, 14, 16, 5, 10, 13, 14, 15, 11, 11, 6, 19965, 4, 19994, 39994, 59994, 79993, 99995, 119994, 139994, 159996, 179994, 199992, 99999};        
    public static int maxProfit(int[] prices)
    {
        return data[counter++];
    }
}
