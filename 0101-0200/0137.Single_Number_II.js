//4ms



/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    let map = new Map();
    let ans;
    for(let i=0;i<nums.length;i++){
        map.set(nums[i],(map.get(nums[i])||0)+1);
    }
    map.forEach((val,key)=>{
        if(val==1){
            ans = key;
        }
    })
    return ans;
};



//4ms same




/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    let hashMap = new Map();
    for (let num of nums) {
        hashMap.set(num, (hashMap.get(num) || 0) + 1);
    }
    for (const [key,value] of hashMap) {
        if (hashMap.get(key) === 1) {
            return key;
        }
    }
};





//2ms







/**
 * Находит уникальный элемент в массиве, где все остальные встречаются трижды
 * @param {number[]} nums Входной массив чисел
 * @return {number} Уникальный элемент
 */
var singleNumber = function(nums) {
    let ones = 0, twos = 0;
    for (const num of nums) {
        // Добавляем в ones элементы, встретившиеся первый раз
        // и удаляем те, что уже есть в twos (т.е. встретились дважды)
        ones = (ones ^ num) & ~twos;
        
        // Добавляем в twos элементы, встретившиеся второй раз
        // и удаляем те, что уже есть в ones (т.е. встретились трижды)
        twos = (twos ^ num) & ~ones;
    }
    return ones;
};
