//0ms



impl Solution {
    pub fn find_min(nums: Vec<i32>) -> i32 {
        let (mut left, mut right): (usize, usize) = (0, nums.len()-1);
        
        if nums[left] < nums[right] {
            return nums[left];
        }
        
        while left < right {
            let mid = left + (right-left)/2;
            
            if nums[mid] > nums[right] {
                left = mid+1;
            } else if nums[mid] < nums[right] {
                right = mid;
            } else {
                right-=1;  //avoid duplication
            }
        }
        
        nums[right]
    }
}





//0ms





impl Solution {
    pub fn find_min(nums: Vec<i32>) -> i32 {
        let mut min = i32::MAX;
        for n in nums {
            min = min.min(n);
        }
        min
    }
}
