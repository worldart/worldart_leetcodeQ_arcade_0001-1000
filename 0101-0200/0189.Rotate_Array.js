//1ms





/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    let n = nums.length;
    k %= n;

    function reverse(l, r) {
        while (l < r) {
            [nums[l], nums[r]] = [nums[r], nums[l]];
            l++;
            r--;
        }
    }

    reverse(0, n - 1);
    reverse(0, k - 1);
    reverse(k, n - 1);
};





//0ms






/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    k = k % nums.length;
    nums = nums.reverse();
    rotateArray(nums, 0, k - 1);
    rotateArray(nums, k, nums.length - 1);
};

function rotateArray(nums, start, end) {
    if (start === end) {return}

    while (start < end) {
        var temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}





//1ms






/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
function rotate(nums, k) {
    const size = nums.length;
    k = k % size;

    let start = 0, count = 0;
    while (count < size) {
        let current = start;
        let prev = nums[start];
        do {
            const next = (current + k) % size;
            const temp = nums[next];
            nums[next] = prev;
            prev = temp;
            current = next;
            count++;
        } while (start !== current);
        start++;
    }
}
