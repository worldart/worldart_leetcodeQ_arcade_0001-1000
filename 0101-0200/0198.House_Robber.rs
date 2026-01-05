//0ms




impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        nums.iter().fold((0, 0), |(a, b), x| (b, b.max(a + x))).1
    }
}



//0ms




impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        match nums.len() {
            0 => 0,
            1 => nums[0],
            2 => nums[0].max(nums[1]),
            3 => nums[0].max(nums[1]).max(nums[0] + nums[2]),
            n => {
                let mut a = nums[0];
                let mut b = nums[1];
                let mut c = nums[0] + nums[2];
                for index in 3..n {
                    (a, b, c) = (b, c, (a + nums[index]).max(b + nums[index]));
                }
                b.max(c)
            }
        }
    }
}





//0ms





impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        if nums.is_empty() {
            return 0;
        }
        if nums.len() == 1 {
            return nums[0];
        }

        let mut prev_prev = nums[0];
        let mut prev = nums[0].max(nums[1]);

        for i in 2..nums.len() {
            let current = prev_prev + nums[i];
            prev_prev = prev;
            prev = current.max(prev);
        }

        prev
    }
}




//0ms





use std::cmp::max;
impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        if(n == 1){
            return nums[0];
        }else if(n == 2){
            return max(nums[0],nums[1]);
        }
        let (mut a,mut b,mut c) = (nums[0],max(nums[0],nums[1]),0);
        for i in (2..n){
            c = max(nums[i] + a, b);
            a = b;
            b = c;
        }
        return c;
    }
}
