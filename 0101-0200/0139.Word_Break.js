//7ms



/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
    const wordSet = new Set(wordDict);
    const dp = Array(s.length + 1).fill(false);
    dp[0] = true;

    for (let i = 1; i <= s.length; i++) {
        for (let j = 0; j < i; j++) {
            if (dp[j] && wordSet.has(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        }
    }

    return dp[s.length];
};




//0ms




/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
      const set = new Set(wordDict);
  const dp = new Array(s.length + 1).fill(false);
  const maxWordLen = Math.max(...wordDict.map(word => word.length))
  dp[0] = true;

  for(let i = 0; i <= s.length; i++){
    for(let j = Math.max(0, i - maxWordLen); j < i; j++){
      if(dp[j] && set.has(s.substring(j, i))){
        dp[i] = true;
        break;
      }
    }
  }

  return dp[s.length]
};
