//0ms





/**
 * @param {number} columnNumber
 * @return {string}
 */
var convertToTitle = function(columnNumber) {
    let ans = "";
    while(columnNumber !== 0){
        columnNumber--;
        ans = String.fromCharCode((columnNumber%26)+65) + ans;
        columnNumber = Math.floor(columnNumber/26);
    }
    return ans;
};





//0ms






/**
 * @param {number} columnNumber
 * @return {string}
 */
const arr = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
var convertToTitle = function (columnNumber) {
    const title = [];
    while (columnNumber > 0) {
        let n = (columnNumber - 1) % 26;
        title.push(arr[n]);
        columnNumber = Math.floor((columnNumber-1) / 26);
    }
    return title.reverse().join('');
};
