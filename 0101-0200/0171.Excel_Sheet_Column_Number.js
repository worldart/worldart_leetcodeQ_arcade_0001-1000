//0ms






/**
 * @param {string} columnTitle
 * @return {number}
 */
var titleToNumber = function(columnTitle) {
    let result = 0;
    let length = columnTitle.length;
    for(let i = 0; i < length; i++){
        result += (columnTitle.charCodeAt(i) - 64) * Math.pow(26, length - (i + 1));
    }
    return result;
};






//1ms






/**
 * @param {string} columnTitle
 * @return {number}
 */
var titleToNumber = function(columnTitle) {
    let title = 0;
    for(let i = 0; i < columnTitle.length; i++){
        let num = columnTitle[i].toUpperCase().charCodeAt(0) - 64;
        title = title * 26 + num;
    }
    return title;
};
