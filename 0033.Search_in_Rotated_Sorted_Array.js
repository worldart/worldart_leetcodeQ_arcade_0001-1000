//0ms Binary Search

var search = function(nums, target) {
    let start = 0, end = nums.length - 1;
    let mid = Math.floor((start + end) / 2);
    while (start <= end) {
        mid = Math.floor((start + end) / 2);
        if (target === nums[mid]) {
            return mid;
        }
        if (nums[start] <= nums[mid]) {
            if (nums[start] <= target && nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else {
            if (nums[end] >= target && nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
    return -1;
}
