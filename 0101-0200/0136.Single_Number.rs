//0ms




use std::ops::BitXor;

impl Solution {
    pub fn single_number(nums: Vec<i32>) -> i32 {
        nums
            .into_iter()
            .fold(0, i32::bitxor)
    }
}




//0ms





impl Solution {
    pub fn single_number(nums: Vec<i32>) -> i32 {
        let mut xor=0;for i in 0..nums.len(){xor^=nums[i];}xor
    }
}


