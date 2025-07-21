//0ms




/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let left = 0;
    let right = nums.length -1;

    while(left < right ) {
        let mid = Math.floor((left + right)/2)

        if(nums[mid] > nums[right]){
            left = mid + 1;
        } 
        else if(nums[mid] < nums[right]){
            right = mid;
        }else {
            right --
        }

    }
    return nums[left];
};




//0ms




var findMin = function(nums) {
    let start = 0;
    let end = nums.length - 1;

    while (start < end) {
        let mid = Math.floor((start + end) / 2);

        if (nums[mid] < nums[end]) {
            end = mid;  // min must be in left half including mid
        } else if (nums[mid] > nums[end]) {
            start = mid + 1;  // min must be in right half
        } else {
            // nums[mid] == nums[end], can't decide, reduce end
            end--;
        }
    }

    return nums[start];  // or nums[end], since start == end
};
