//2ms


/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    const str = s.replace(/[^a-z0-9]/gi, "").toLowerCase()

    const palinStr = str.split("").reverse().join("")

    return str === palinStr
    
};





//1ms



/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    const cleaned = s.replace(/[^a-z0-9]/gi, '').toLowerCase();
    return cleaned === cleaned.split('').reverse().join('');
};
