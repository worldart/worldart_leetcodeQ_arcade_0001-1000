//100%RT

use std::iter::once;

impl Solution {
    fn recurse(curr: &[u8], left: i32) -> Vec<u8> {
        if left == 1 {
            curr.to_vec()
        } else {
            let mut next = vec![];
            let mut slow = 0;
            for fast in 0..=curr.len() {
                if fast == curr.len() || curr[slow] != curr[fast] {
                    next.extend(once((fast - slow) as u8).chain(once(curr[slow] as u8)));
                    slow = fast;
                }
            }
            Self::recurse(&next, left - 1)
        }
    }

    pub fn count_and_say(n: i32) -> String {
        Self::recurse(&[1], n).into_iter().map(|digit| (digit + b'0') as char).collect()
    }
}
