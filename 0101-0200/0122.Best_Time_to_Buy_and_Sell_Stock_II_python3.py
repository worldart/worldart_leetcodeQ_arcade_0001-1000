#0ms


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        has_stock = False
        buy_price = 0
        money = 0
        for price, next_price in zip(prices[:-1], prices[1:]):
            if next_price < price and has_stock:
                has_stock = False
                money += price - buy_price
            if not has_stock and next_price > price:
                has_stock = True
                buy_price = price
        if has_stock:
            money += prices[-1] - buy_price
        return money
