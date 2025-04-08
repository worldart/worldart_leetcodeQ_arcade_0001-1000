//100%RT

use std::cmp;

impl Solution {
    pub fn merge(mut intervals: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        intervals.sort_by_key(|interval| interval[0]);

        let mut result = Vec::with_capacity(intervals.len());
        let mut current = vec![intervals[0][0], intervals[0][1]];

        for interval in intervals.into_iter().skip(1) {
            if current[1] >= interval[0] {
                current[1] = cmp::max(current[1], interval[1]);
            } else {
                result.push(current);
                current = interval;
            }
        }

        result.push(current);
        result
    }
}

