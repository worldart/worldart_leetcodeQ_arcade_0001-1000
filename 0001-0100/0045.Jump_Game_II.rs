//100%RT

use std::cmp;

// Define the Solution struct (not used in this implementation)


impl Solution {
    // Define the jump function associated with the Solution struct
    pub fn jump(nums: Vec<i32>) -> i32 {
        // set variables
        let mut jumps = 0;
        let mut max_distance = 0;
        let mut current_pos = 0;

        // loop over nums array until end reached.
        for i in 0..nums.len() {
            if i == nums.len() - 1 {
                break;
            }

            // check which is further, current reach or new reachable
            max_distance = cmp::max(max_distance, nums[i] + i as i32);

            // if this iteration is the current step.
            if current_pos == i as i32 {
                // increment jump count.
                jumps += 1;

                // set current position to the max jump
                current_pos = max_distance;
            }
        }

        // return jumps
        jumps
    }
}
