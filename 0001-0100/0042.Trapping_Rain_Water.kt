//74.84%RT

class Solution {
    fun trap(height: IntArray): Int {
        var total = 0 // Initialize total water trapped
        var l = 0 // Left pointer
        var r = height.size - 1 // Right pointer
        var lmax = 0 // Max height on the left
        var rmax = height[r] // Max height on the right
        
        while (l < r) {
            if (height[l] <= height[r]) {
                // If left height is less than or equal to right height
                if (height[l] < lmax) {
                    total += lmax - height[l] // Water trapped on the left
                } else {
                    lmax = height[l] // Update left max height
                }
                l++ // Move left pointer
            } else {
                // If right height is less than left height
                if (height[r] < rmax) {
                    total += rmax - height[r] // Water trapped on the right
                } else {
                    rmax = height[r] // Update right max height
                }
                r-- // Move right pointer
            }
        }
        return total // Return

    }
}
