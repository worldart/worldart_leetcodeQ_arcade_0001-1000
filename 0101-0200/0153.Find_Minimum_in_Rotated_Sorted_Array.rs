//0ms




use std::cmp::Ordering::{Greater, Less, Equal};

impl Solution {
    pub fn find_min(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let k = Self::find_peak(&nums);
        nums[k%n]
    }

    fn find_peak(nums: &Vec<i32>) -> usize {
        let (mut lbound, mut ubound) = (0, nums.len());
        while lbound < ubound {
            let mid = (lbound+ubound)/2;
            match nums[mid].cmp(&nums[0]) {
                Greater|Equal => {lbound = mid+1;}
                Less => {ubound = mid;}
            }
        }
        ubound
    }
}




//0ms






impl Solution {
    pub fn find_min(nums: Vec<i32>) -> i32 {
        let (mut left, mut right) = (0i32, nums.len() as i32 - 1);

        while left < right {
            let mut mid = left + (right - left) / 2;

            if nums[mid as usize] > nums[right as usize] {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        nums[left as usize]
    }
}
