//3ms



/**
 * @param {number[]} ratings
 * @return {number}
 */
var candy = function(ratings) {
    const n = ratings.length;
    let totalCandies = n;
    let i = 1;

    while (i < n) {
        if (ratings[i] === ratings[i - 1]) {
            i++;
            continue;
        }

        let currentPeak = 0;
        while (i < n && ratings[i] > ratings[i - 1]) {
            currentPeak++;
            totalCandies += currentPeak;
            i++;
        }

        if (i === n) {
            return totalCandies;
        }

        let currentValley = 0;
        while (i < n && ratings[i] < ratings[i - 1]) {
            currentValley++;
            totalCandies += currentValley;
            i++;
        }

        totalCandies -= Math.min(currentPeak, currentValley);
    }

    return totalCandies;    
};



//2ms



/**
 * @param {number[]} ratings
 * @return {number}
 */
var candy = function (ratings) {
    let candiesGivenOut = 1;
    let max = ratings[0];
    let maxIdx = 0;
    let count = 1;
    let leeway = 0;

    for (let i = 1; i < ratings.length; i++) {
        if (ratings[i] >= ratings[i - 1]) {
            if (ratings[i] === ratings[i - 1]) {
                candiesGivenOut = 1;
            } else {
                candiesGivenOut++;
            }
            count += candiesGivenOut;
            max = ratings[i];
            maxIdx = i;
            leeway = 0;
        } else {
            if (candiesGivenOut > 1) {
                leeway = candiesGivenOut - 2;
                count += 1;
                candiesGivenOut = 1;
            } else {
                count += i - maxIdx + 1 - (leeway > 0 ? 1 : 0);
                if (leeway > 0) leeway--;
            }
        }
    }

    return count;
};



