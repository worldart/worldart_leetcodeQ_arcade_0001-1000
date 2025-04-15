//23ms


/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var numDistinct = function(s, t) {
  
  const n = s.length;
  const m = t.length;
    
  const previous = new Array(m + 1).fill(0);
  previous[0] = 1;
    
  for (let i = 1; i <= n; i += 1) {    
    for (let j = m; j >= 1; j -= 1) {
      if (s[i - 1] === t[j - 1]) {
        previous[j] += previous[j - 1];
      } 
    }
  }
  
  return previous[m];
};
