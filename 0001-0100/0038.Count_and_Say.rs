//100%RT

use std::iter::once;

impl Solution {
    pub fn count_and_say(n: i32) -> String {
        let mut curr = vec![1];
        for _ in 1..n {
            let mut next = vec![];
            let mut slow = 0;
            for fast in 0..=curr.len() {
                if fast == curr.len() || curr[slow] != curr[fast] {
                    next.extend(once((fast - slow) as u8).chain(once(curr[slow] as u8)));
                    slow = fast;
                }
            }
            curr = next;
        }
        curr.into_iter().map(|digit| (digit + b'0') as char).collect()
    }
}
