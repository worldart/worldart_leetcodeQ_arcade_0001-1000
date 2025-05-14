//33ms



var partition = function(s) {
    const isPalindrome = (sub) => {
        let left = 0, right = sub.length - 1;
        while (left < right) {
            if (sub[left++] !== sub[right--]) {
                return false;
            }
        }
        return true;
    };
    
    const backtrack = (start, path, partitions) => {
        if (start === s.length) {
            partitions.push([...path]);
            return;
        }
        
        for (let end = start + 1; end <= s.length; end++) {
            const sub = s.substring(start, end);
            if (isPalindrome(sub)) {
                path.push(sub);
                backtrack(end, path, partitions);
                path.pop();
            }
        }
    };
    
    const partitions = [];
    backtrack(0, [], partitions);
    return partitions;
};




//13ms




/**
 * @param {string} s
 * @return {string[][]}
 */

const isPalindrome = (str) =>{
    let left = 0;
    let right = str.length - 1;

    while(left < right){
        if(str[left++] != str[right--]) return false;
    }
    return true;
}

const generate = (
    result, str, len, idx, list
)=>{
    if(idx === len){
        result.push([...list]);
        return;
    }

    let currStr = ""

    for(let i = idx; i < len; i++){
        currStr += str[i];
        
        if(isPalindrome(currStr)){
            list.push(currStr);
            generate(result, str, len, i + 1, list)
            list.pop();
        }
    }
}
const partition = (s)=> {
    const result = [];
    generate(result, s, s.length, 0, []);
    return result;
};

partition("aab");
partition("a");





//11ms




/**
 * @param {string} s
 * @return {string[][]}
 */
function isPalindrome(s, i, j, dp) {
    if (i >= j) return true;
    if (s[i] !== s[j]) return false;
    if (dp[i][j] !== -1) return dp[i][j];

    dp[i][j] = isPalindrome(s, i + 1, j - 1, dp);
    return dp[i][j];
}

var partition = function (s) {
    const n = s.length;
    const res = [];
    const temp = [];
    const dp = Array.from({ length: n+1 }, () => new Array(n+1).fill(-1));

    function solve(idx) {
        if (idx === n) {
            res.push([...temp]);
            return;
        }

        for(let j=idx; j<n; j++) {
            const str = s.slice(idx, j+1);
            if (isPalindrome(s, idx, j, dp)) {
                temp.push(str);
                solve(j+1);
                temp.pop();
            }
        }
    }

    solve(0);
    return res;
};
