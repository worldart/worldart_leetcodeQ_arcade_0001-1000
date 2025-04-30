//6ms


class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        // divide & conqure method considering 2 txn max
        vector<int> leftProfit(n, 0);
        vector<int> rightProfit(n, 0);
        int profit = 0;

        // determine profit on left
        // buy first then sell
        int leftBuy = prices[0];
        for(int i = 1; i < n; i++){
            // check whether to buy
            if (prices[i] < leftBuy) {
                leftBuy = prices[i];
            }
            // check to sell and memoize max profit till this point comparing previous profit
            leftProfit[i] = max(leftProfit[i-1], (prices[i] - leftBuy));
        }

        // determine profit on right
        // sell first then buy
        int rightSell = prices[n-1];
        for(int i = n-2; i >= 0; i--){
            // check whether to sell
            if (prices[i] > rightSell) {
                rightSell = prices[i];
            }
            // check to buy and meomize max profit till this point comparing previous profit
            rightProfit[i] = max(rightProfit[i+1], (rightSell - prices[i]));
        }

        // determine max Profit based on two parts
        for (int i = 0; i < n; i++) {
            profit = max(profit, (leftProfit[i] + rightProfit[i]));
        }

        return profit;
    }
};
