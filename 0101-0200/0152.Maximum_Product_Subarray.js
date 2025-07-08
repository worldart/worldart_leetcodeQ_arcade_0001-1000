//2ms





/**
 * @param {number[]} nums
 * @return {number}
 */


//  HAil Striver  ************
var maxProduct = function(nums)   {      
    let prefix =1
    let suffix = 1
    let ans=nums[0]

    for(let i=0; i<nums.length; i++){
        if(prefix===0){
            prefix=1
        }
        if(suffix===0){
            suffix=1
        }

        suffix= suffix*nums[i]
        prefix= prefix*nums[nums.length-i-1]
        ans=Math.max(ans,prefix,suffix)
    }
    return ans
};







//3ms





/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    let i = 0;
    let n = nums.length;
    let prefix = 1;
    let suffix = 1;
    let ans = nums[0];

    while(i<n){
        if(prefix == 0) prefix = 1;
        if(suffix == 0) suffix = 1;
        
        prefix *= nums[i];
        suffix *= nums[n-i-1];
        ans = Math.max(ans,suffix, prefix);
        i++;
    }

    return ans;
};
