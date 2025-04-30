//2ms


var maxProfit = function(prices) {
    let buy1 = -Infinity, buy2 = -Infinity;
    let sell1 = 0, sell2 = 0;
    for (let i = 0; i < prices.length; i++) {
        buy1 = Math.max(buy1, -prices[i]);
        sell1 = Math.max(sell1, buy1 + prices[i]);
        buy2 = Math.max(buy2, sell1 - prices[i]);
        sell2 = Math.max(sell2, buy2 + prices[i]);
    }
    return sell2; 
};



//4ms


/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {

    let buy1 = Number.NEGATIVE_INFINITY;
    let sell1 = 0;
    let buy2 = Number.NEGATIVE_INFINITY;
    let sell2 = 0;

    for(price of prices){
        buy1 = Math.max(buy1,-price); // cashflow impact if we buy for the fist time
        sell1 = Math.max(sell1,price+buy1); // cashflow impact if we sell for the first time
        buy2 = Math.max(buy2,sell1-price); //chaining the first result
        sell2 = Math.max(sell2,price+buy2);
    }


    return sell2;
    
};
