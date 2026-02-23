//1ms





var isHappy = function(n) {
    if(n<10){
        if(n === 1 || n === 7){
            return true
        }
        return false
    }
    let total = 0
    while(n>0){
        let sq = n % 10
        total += sq**2
        n -= sq
        n /= 10
    }
    if(total === 1){
        return true
    }
    return isHappy(total)
};





//0ms






/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
   while (n >5) {
    let sum = 0;
    while (n > 0) {
        let m = n%10;
        sum += m*m;
        n = Math.floor(n/10);
    }
    n = sum;  
}
if(n === 1){
    return true;
}

return false;
};





//0ms





/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    
    let set = new Set();

    while (n !== 1 && !set.has(n)) {
        set.add(n);
        let sum = 0;

        while (n > 0) {
            let digit = n % 10;
            sum += digit * digit;
            n = Math.trunc(n / 10);
        }
        n = sum;
    }
    return n === 1;
};
