11ms


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = prices.pop(0)
        sel, profit = buy, 0

        for price in prices:
            if price < buy:
                buy, sel = price, price
            elif price > sel:
                sel = price
                if sel - buy > profit:
                    profit = sel - buy
        return profit



#9ms

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        low = prices[0]
        high = prices[0]
        max_profit = 0

        for price in prices:
            if price > high:
                high = price
                if high - low > max_profit:
                    max_profit = high - low 

            elif price < low:
                low = price
                high = price

        return max_profit



#30ms


class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        min_price = prices[0]
        profit = 0
        for p in prices:
            if p < min_price:
                min_price = p
            if p - min_price > profit:
                profit = p - min_price

        return profit
