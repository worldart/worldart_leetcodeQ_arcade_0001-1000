//21ms



/**
 * @param {string} s
 * @return {number}
 */
var minCut = function(s) {
    const n = s.length;
    //creating an array to keep track of number of cuts required till that length
    //by default considering every element is an array in itself so array looks like [0,1,2,3....n-1]
    const dp = Array.from({ length: n }, (_, i) => i);

    for (let mid = 1; mid < n; mid++) {
        //case when even number of letters are there in pallindrome
        //starting from mid, expand on both sides till there is a pallindrome so keep on doing start-- and end++
        for (let start = mid, end = mid; start >= 0 && end < n && s[start] === s[end]; start--, end++) {
            //if start is not 0 that means, whatever number of cuts we have, we got 1 more cut so add
            const newCntEnd = !start ? 0 : dp[start - 1] + 1;
            //that means at current end point number of cuts= min of what I already counted or new total cuts got 
            dp[end] = Math.min(dp[end], newCntEnd);
        }
        
        //case when odd numbers of words are there in pallindrome
        //starting from mid-1(leaving mid value as center), expand on both sides till there is a pallindrome so keep on doing start-- and end++
        for (let start = mid - 1, end = mid; start >= 0 && end < n && s[start] === s[end]; start--, end++) {
            //if start is not 0 that means, whatever number of cuts we have, we got 1 more cut so add
            const newCntEnd = !start ? 0 : dp[start - 1] + 1;
            //that means at current end point number of cuts= min of what I already counted or new total cuts got 
            dp[end] = Math.min(dp[end], newCntEnd);
        }
    }
//retrning number of cuts for last value
    return dp[n - 1];
};







//27ms







/**
 * @param {string} s
 * @return {number}
 */
var minCut = function (s) {
	const n = s.length;
	const results = new Array(n + 1).fill(Infinity);
	results[0] = -1;
	let i, stride;
	for (i = 0; i < n; i++) {
		if (results[i + 1] > results[i] + 1) results[i + 1] = results[i] + 1;
		for (stride = 1; i - stride >= 0 && i + stride < n && s[i - stride] === s[i + stride]; stride++) {
			if (results[i + stride + 1] > results[i - stride] + 1) results[i + stride + 1] = results[i - stride] + 1;
		}
		for (stride = 0; i - stride >= 0 && i + 1 + stride < n && s[i - stride] === s[i + 1 + stride]; stride++) {
			if (results[i + 2 + stride] > results[i - stride] + 1) results[i + 2 + stride] = results[i - stride] + 1;
		}
	}
	return results[n];
};






//26ms






/**
 * @param {string} s
 * @return {number}
 */
var minCut = function(s) {
    const n = s.length;
    const dp = Array(n).fill(0);
    for (let i = 0; i < n; i++) {
        dp[i] = i;
    }
    for (let i = 0; i < n; i++) {
        expandAroundCenter(s, i, i, dp);
        expandAroundCenter(s, i, i + 1, dp);
    }
    return dp[n - 1]; 
};

function expandAroundCenter(s, left, right, dp) {
    while (left >= 0 && right < s.length && s[left] === s[right]) {
        dp[right] = Math.min(dp[right], (left === 0 ? 0 : dp[left - 1] + 1));
        left--;
        right++;
    }
}
