//8ms 98.57%RT

/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    let n = s.length;
    let m = t.length;
    let minlen = Infinity;
    let sIndex = -1;
    let hashArray = new Array(256).fill(0);
    let count = 0;

    let l = 0;
    let r = 0;

    for (let i = 0; i < m; i++) {
        hashArray[t.charCodeAt(i)]++;
    }

    while (r < n) {
        if (hashArray[s.charCodeAt(r)] > 0) {
            count++;
        }
        hashArray[s.charCodeAt(r)]--;

        while (count == m) {
            if (r - l + 1 < minlen) {
                minlen = r - l + 1;
                sIndex = l;
            }
            hashArray[s.charCodeAt(l)] += 1;
            if (hashArray[s.charCodeAt(l)] > 0) {
                count -= 1;
            }
            l++;
        }
        r++;
    }
    return sIndex == - 1 ? "" : s.substring(sIndex, sIndex + minlen);
};
