//11ms





/**
 * @param {number[]} nums
 * @return {string}
 */
var largestNumber = function(nums) {
    // Convert integers to strings
    let array = nums.map(String);
    
    // Custom sorting with a comparator function
    array.sort((a, b) => (b + a).localeCompare(a + b));
    
    // Handle the case where the largest number is "0"
    if (array[0] === "0") {
        return "0";
    }
    
    // Build the largest number from the sorted array
    return array.join('');
};





//3ms







/**
 * @param {number[]} nums
 * @return {string}
 */
var largestNumber = function(nums) {
    // Convert to string first (to handle concatenation correctly)
    let sortss = nums.map(String).sort((a, b) => (b + a) - (a + b));

    // Join into result
    let result = sortss.join('');

    // Handle case like [0,0] -> "0" not "00"
    return result[0] === '0' ? '0' : result;
};
