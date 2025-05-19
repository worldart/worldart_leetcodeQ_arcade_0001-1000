//16ms



/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function (nums) {
  let arr = nums.sort((a, b) => a - b); // Create a copy of the array and sort it

  for (let i = 0; i <= nums.length - 1; i += 2) { // Iterate by 2
    if (arr[i] !== arr[i + 1]) {
      return arr[i];
    }
  }

  return arr[arr.length - 1];  // Return the first non-matching pair
};




//1ms




/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    return nums.reduce((result, num) => result ^ num, 0);
};




//5ms




/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    const set = new Set();
    const res = [];
    for( let i = 0; i < nums.length; i++ ){
        if(set.has(nums[i])) set.delete(nums[i]);
        else set.add(nums[i]);
    }
    for(let value of set) {
        res.push(value)
    }
    return res[0];
};
