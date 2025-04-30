//1ms


use std::cmp::{min, max};

impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        if prices.is_empty() {
            return 0;
        }
        let n = prices.len();
        let (mut fwd, mut bwd) = (vec![0; n], vec![0; n]);
        let (mut b, mut s) = (std::i32::MAX, 0);
        prices.iter().enumerate().for_each(|(i, p)| {
            fwd[i] = if i == 0 { 0 } else { max(fwd[i-1], p-b) };
            b = min(b, *p);
        });
        (0..n).rev().for_each(|i| {
            let p = prices[i];
            bwd[i] = if i == n-1 { 0 } else { max(bwd[i+1], s-p) };
            s = max(s, p);
        });
        (0..n).fold(0, |acc, i| max(fwd[i] + bwd[i], acc))
    }
}



//0ms


impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        let n = prices.len();
        let (mut pre, mut suf) = (vec![0; n],vec![0; n]);
        let mut mn = i32::MAX;
        for i in (0..n) {
            mn = mn.min(prices[i]);
            pre[i] = std::cmp::max(0, prices[i] - mn);
        }
        for i in (1..n) {
            pre[i] = pre[i].max(pre[i-1]);
        }
        let mut mx = 0;
        for i in (0..n).rev() {
            mx = mx.max(prices[i]);
            suf[i] = std::cmp::max(0, mx - prices[i]);
        }
        for i in (0..n-1).rev() {
            suf[i] = suf[i].max(suf[i+1]);
        }
        let mut ans = 0;
        for i in (0..n) {
            ans = ans.max(pre[i] + if i + 1 < n { suf[i+1] } else { 0 });
        }
        ans
    }
}
