//0ms


class Solution {
    public int maxProfit(int[] prices) {
        
        // It is impossible to sell stock on first day, set -infinity as initial value for cur_hold
        int hold = -Integer.MAX_VALUE, notHold = 0;
        
        for( int stockPrice : prices ){
            
            int prevHold = hold, prevNotHold = notHold;
            
            // either keep hold, or buy in stock today at stock price
            hold = Math.max(prevHold, prevNotHold - stockPrice);
            
            // either keep not-hold, or sell out stock today at stock price
            notHold = Math.max(prevNotHold, prevHold + stockPrice);
            
        }
        
        // maximum profit must be in not-hold state
        return notHold;
        
    }
}
