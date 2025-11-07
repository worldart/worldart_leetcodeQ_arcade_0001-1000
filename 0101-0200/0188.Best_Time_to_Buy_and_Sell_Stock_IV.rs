//0ms




impl Solution {
    pub fn max_profit(k: i32, prices: Vec<i32>) -> i32 {
        let k = k as usize;
        let n = prices.len();
        let mut dp_prev = vec![(0, 0); n + 1];
        let mut dp_curr = dp_prev.clone();
        for _ in 0..k {
            for day in (0..n).rev() {
                dp_curr[day].0 = dp_curr[day + 1].0.max(-prices[day] + dp_curr[day + 1].1);
                dp_curr[day].1 = dp_curr[day + 1].1.max(prices[day] + dp_prev[day + 1].0);
            }
            std::mem::swap(&mut dp_prev, &mut dp_curr);
        }

        dp_prev[0].0
    }
}





//0ms





impl Solution {
    pub fn max_profit(k: i32, prices: Vec<i32>) -> i32 {
        if prices.len() == 1 { return 0; }
        
        let mut dfa = vec![i32::MIN; 2*k as usize];
        dfa[0] = -prices[0];

        for v in &prices[1..] {
            dfa[0] = dfa[0].max(-v);
            dfa[1] = dfa[1].max(dfa[0] + v);
            for i in (2..dfa.len()-1).step_by(2) {
                dfa[i] = dfa[i].max(dfa[i-1] - v);
                dfa[i+1] = dfa[i+1].max(dfa[i] + v);
            }
        }

        *dfa.last().unwrap()
    }
}
