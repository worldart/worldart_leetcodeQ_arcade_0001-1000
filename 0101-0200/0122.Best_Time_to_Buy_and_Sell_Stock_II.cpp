//0ms


class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();

        int maxHolding = INT_MIN;
        int maxNotHolding = 0;

        for (int day = 0; day < n; ++day) {
            maxNotHolding = std::max(maxNotHolding, maxHolding + prices[day]);
            maxHolding = std::max(maxHolding, maxNotHolding - prices[day]);
        }

        return maxNotHolding;
    }
};
