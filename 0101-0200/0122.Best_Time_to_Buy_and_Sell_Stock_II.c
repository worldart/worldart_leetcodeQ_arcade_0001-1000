//0ms



#define MAX(a,b) ((a) > (b) ? (a) : (b))

int maxProfit(int* prices, int pricesSize){
    // It is impossible to sell stock on first day, set -infinity as initial value for curHold
    int curHold = INT_MIN, curNotHold = 0;

    for( int i = 0 ; i < pricesSize ; i++ ){
        
        int stockPrice = prices[i];
        
        int prevHold = curHold, prevNotHold = curNotHold;

        // either keep hold, or buy in stock today at stock price
        curHold = MAX( prevHold, prevNotHold - stockPrice );

        // either keep not-hold, or sell out stock today at stock price
        curNotHold = MAX( prevNotHold, prevHold + stockPrice );
    }

    // Max profit must come from notHold state finally.
    return curNotHold;
}
