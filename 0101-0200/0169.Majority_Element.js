//0ms






/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    let ans= nums[0]
    let count = 1
    for(let i=1;i<nums.length;i++){
        if(count ==0){
            ans = nums[i]
            count=1
        }else if(ans ==nums[i]){
            
            count ++
        }else {
            count--
        }
    }
    return ans
};







//10ms






/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    let obj = [];
    for(let i = 0; i < nums.length; i++) {
        let elem = obj.find(item => item.val == nums[i]);
        if(elem) {
            elem.count++;
        } else {
            obj.push({ val: nums[i], count: 1 });
        }
    }

    obj.sort((a, b) => b.count - a.count);

    return obj[0].count > nums.length / 2 ? obj[0].val : 0;
};






//1ms






/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    let i=0;
    let count=0;
    let majorityElement=nums[0]
    while(i<nums.length){
       if(count==0){
        majorityElement=nums[i]
        count=1
       }
       else if(nums[i]==majorityElement){
        count++;
       }
     else  count--;
     i++;

    }

    return majorityElement;
};
