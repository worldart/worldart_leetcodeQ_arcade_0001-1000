//2m s





/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (numbers, target) {
    let i = 0;
    let j = numbers.length - 1;
    while (j > i) {
        if (numbers[i] + numbers[j] === target) {
            return [i+1,j+1]
        } else if (numbers[i] + numbers[j] > target){
            j--;
        } else {
            i++
        }
    }
};





//1ms





/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (numbers, target) {
    let left = 0;
    let right = numbers.length - 1;

    while (left < right) {
        const sum = numbers[left] + numbers[right];
        if (sum === target) {
            return [left + 1, right + 1];
        }
        else if (sum < target) {
            left++;
        }
        else {
            right--;
        }
    }
};
