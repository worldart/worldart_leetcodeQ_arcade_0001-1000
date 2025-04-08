//100%RT

impl Solution {
    pub fn trap(height: Vec<i32>) -> i32 {
        let mut total = 0; // Initialize total water trapped
        let mut l = 0; // Left pointer
        let mut r = height.len() - 1; // Right pointer
        let mut lmax = 0; // Max height for left
        let mut rmax = height[r]; // Max height for right
        
        while l < r {
            if height[l] <= height[r] {
                // If left height is less than or equal to right height
                if height[l] < lmax {
                    total += lmax - height[l]; // Water trapped on the left
                } else {
                    lmax = height[l]; // Update left max height
                }
                l += 1; // Move left pointer
            } else {
                // If right height is less than left height
                if height[r] < rmax {
                    total += rmax - height[r]; // Water trapped on the right
                } else {
                    rmax = height[r]; // Update right max height
                }
                r -= 1; // Move right pointer
            }
        }
        total // Return total water trapped
    }
}
