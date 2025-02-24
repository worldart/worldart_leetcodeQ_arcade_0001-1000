//0ms

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    let start  = 0;
    let mid = 0;
    let high = nums.length-1;
    while(mid<=high){
        if(nums[mid]==0){
            [nums[mid],nums[start]] = [nums[start], nums[mid]];
            start++;
            mid++;
        }else if(nums[mid]==1){
            mid++;
        }else{
            [nums[mid],nums[high]] = [nums[high], nums[mid]];
            high--;
        }
    }
   
    return nums
};
