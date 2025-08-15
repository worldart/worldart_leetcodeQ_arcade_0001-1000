//0ms






use std::cmp::Ordering;

impl Solution {
    pub fn two_sum(numbers: Vec<i32>, target: i32) -> Vec<i32> {
        let mut i = 0;
        let mut j = numbers.len()-1;
        
        while i < j {
            match (numbers[i]+numbers[j]).cmp(&target) {
                Ordering::Less => i += 1,
                Ordering::Greater => j -= 1,
                Ordering::Equal => return vec![(i+1) as i32, (j+1) as i32],
            }
        }
        unreachable!();
    }
}







0ms






impl Solution {
    pub fn two_sum(numbers: Vec<i32>, target: i32) -> Vec<i32> {
        let (mut right, mut left) = (numbers.len().saturating_sub(1), 0);
        while numbers[left] + numbers[right] != target {
            if numbers[left] + numbers[right] > target {
                right -= 1;
            } else {
                left += 1;
            }
        }
        return vec![(left + 1) as i32, (right + 1) as i32];
    }
}
