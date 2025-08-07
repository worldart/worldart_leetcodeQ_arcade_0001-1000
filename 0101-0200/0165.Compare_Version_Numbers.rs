//0ms





use std::iter::{repeat, zip};

impl Solution {
    pub fn compare_version(v1: String, v2: String) -> i32 {
        let n = v1.len().abs_diff(v2.len());
        let split_parse = |ver: String| -> Vec<i32> {
            ver.split('.')
                .filter_map(|s| s.parse::<i32>().ok())
                .chain(repeat(0).take(n))
                .collect()
        };

        zip(split_parse(v1), split_parse(v2))
            .skip_while(|(a, b)| a == b)
            .map(|(a, b)| if a > b { 1 } else { -1 })
            .next()
            .unwrap_or(0)
    }
}






//0ms





impl Solution {
    pub fn compare_version(version1: String, version2: String) -> i32 {

        let mut iter1 = version1.split('.').map(|s| s.parse::<i32>().unwrap());
        let mut iter2 = version2.split('.').map(|s| s.parse::<i32>().unwrap());

        loop {
            match (iter1.next(), iter2.next()) {
                (Some(r1), Some(r2)) => {
                    if r1 > r2 {
                        break 1;
                    } else if r1 < r2 {
                        break -1;
                    }
                }
                (Some(r1), None) => if r1 > 0 { break 1; },
                (None, Some(r2)) => if r2 > 0 { break -1; },
                (None, None) => break 0,
            }
        }
    }
}
