//0ms






/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function(version1, version2) {
    const v1 = version1.split('.').map(Number);
    const v2 = version2.split('.').map(Number);

    const maxLength = Math.max(v1.length, v2.length);
    while (v1.length < maxLength) v1.push(0);
    while (v2.length < maxLength) v2.push(0);

    for (let i = 0; i < maxLength; i++) {
        if (v1[i] < v2[i]) return -1;
        if (v1[i] > v2[i]) return 1;
    }

    return 0;
};








//0ms








/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function(version1, version2) {
    const v1 = version1.split(".");
    const v2 = version2.split(".");

    const commonLength = Math.min(v1.length, v2.length);

    for (let k = 0; k < commonLength; k++) {
        let s1 = v1[k];
        let s2 = v2[k];
        let i = 0;
        let j = 0;

        while (s1[i] === "0") {
            i++;
        }

        while (s2[j] === "0") {
            j++;
        }

        s1 = s1.slice(i);
        s2 = s2.slice(j);

        if (s1.length > s2.length) {
            return 1;
        } else if (s1.length < s2.length) {
            return -1;
        } else {
            for (let i = 0; i < s1.length; i++) {
                if (s1[i] > s2[i]) {
                    return 1;
                } else if (s1[i] < s2[i]) {
                    return -1;
                }
            }
        }
    };

    if (v1.length > commonLength) {
        for (let i = commonLength; i < v1.length; i++) {
            let s = v1[i];
            let j = 0;

            while (s[j] === "0") {
                j++;
            }

            s = s.slice(j);

            if (s > "0") {
                return 1;
            }
        }
    }

    if (v2.length > commonLength) {
        for (let i = commonLength; i < v2.length; i++) {
            let s = v2[i];
            let j = 0;

            while (s[j] === "0") {
                j++;
            }

            s = s.slice(j);

            if (s > "0") {
                return -1;
            }
        }
    }

    return 0;
};
