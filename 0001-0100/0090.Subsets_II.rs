//0ms


use std::collections::HashSet;

impl Solution {
    pub fn subsets_with_dup(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut nums = nums.clone(); // Clone nums to avoid mutating the input directly
        nums.sort(); // Sort the array to handle duplicates

        let n = nums.len(); 
        let mut result = Vec::new();
        let power_of_two = 1 << n; // 2 ^ n

        for i in 0..power_of_two {
            let mut subset = Vec::new();

            for j in 0..n {
                let currentBit = (i >> j) & 1;

                if currentBit == 1 {
                    subset.push(nums[j])
                }
            }

            result.push(subset);
        }

        return Self::remove_duplicates(result)
    }

    fn remove_duplicates(array: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut set = HashSet::new();

        for subset in array {
            set.insert(subset);
        }

        let unique_subsets: Vec<Vec<i32>> = set.into_iter().collect();
        unique_subsets
    }
}
