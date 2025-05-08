//17ms




use std::collections::HashSet;

impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        let num_set: HashSet<_> = nums.into_iter().collect();
        let mut ans = 0;
        for &num in &num_set {
            if !num_set.contains(&(num - 1)) {
                let count = (num..).take_while(|x| num_set.contains(x)).count();
                ans = ans.max(count);
            }
        }
        ans as i32
    }
}






//0ms






use std::collections::HashSet;

impl Solution {
    pub fn longest_consecutive(mut nums: Vec<i32>) -> i32 {
        if nums.is_empty() {
            return 0;
        }
        nums.sort();

        let mut longest = 1;

        let mut run = 1;

        let mut i = 1;
        while i < nums.len() {
            let v = nums[i];
            if v - 1 == nums[i - 1] {
                run += 1;
            } else {
                run = 1;
            }
            longest = longest.max(run);

            i += 1;
            while i < nums.len() && nums[i] == v {
                i += 1;
            }
        }

        longest
    }
}
