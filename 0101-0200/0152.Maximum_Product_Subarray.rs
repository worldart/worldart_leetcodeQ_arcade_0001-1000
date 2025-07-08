//0mss





impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        let (mut result, mut current_min, mut current_max) = (nums[0], 1, 1);
        for num in nums {
            let store_max = current_max;
            current_max = *[num * store_max, num * current_min, num].iter().max().unwrap();
            current_min = *[num * store_max, num * current_min, num].iter().min().unwrap();
            result = *[current_max, result].iter().max().unwrap();
        }
        return result;
    }
}





//0ms





impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        let result = nums[0];

        nums.into_iter()
            .fold((result, 1, 1), |(result, min, max), x| {
                let next_min = x.min(min * x).min(max * x);
                let next_max = x.max(min * x).max(max * x);
                let result = result.max(next_max);

                (result, next_min, next_max)
            })
            .0
    }
}
