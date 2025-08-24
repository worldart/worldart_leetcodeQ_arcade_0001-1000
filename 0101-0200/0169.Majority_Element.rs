//0ms





impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        nums.into_iter()
            .fold((0, -1), |(count, mut candidate), num| {
                if count == 0 {
                    candidate = num;
                }
                (count + if candidate == num { 1 } else { -1 }, candidate)
            })
            .1
    }
}





//0ms






impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        let mut candidate = nums[0];
        let mut count = 1;
        for i in 1..nums.len() {
            if count == 0 {
                candidate = nums[i];
                count += 1;
            }
            else if candidate == nums[i] {
                count += 1;
            } else {
                count -= 1;
            }
        }
        candidate
    }
}
