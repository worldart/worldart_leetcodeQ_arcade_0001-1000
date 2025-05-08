//36ms


/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    if (!wordList.includes(endWord)) return 0;

    const wordSet = new Set(wordList);
    let beginSet = new Set([beginWord]);
    let endSet = new Set([endWord]);
    let visited = new Set();
    let len = 1;

    while (beginSet.size && endSet.size) {
        // Always expand the smaller set
        if (beginSet.size > endSet.size) {
            [beginSet, endSet] = [endSet, beginSet];
        }

        const nextSet = new Set();

        for (let word of beginSet) {
            for (let i = 0; i < word.length; i++) {
                for (let c = 97; c <= 122; c++) { // 'a' to 'z'
                    const newChar = String.fromCharCode(c);
                    if (newChar === word[i]) continue;

                    const newWord = word.slice(0, i) + newChar + word.slice(i + 1);

                    if (endSet.has(newWord)) return len + 1;

                    if (wordSet.has(newWord) && !visited.has(newWord)) {
                        nextSet.add(newWord);
                        visited.add(newWord);
                    }
                }
            }
        }

        beginSet = nextSet;
        len++;
    }

    return 0;
};







//14ms




/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    if (!wordList.includes(endWord)) return 0;

    const wordSet = new Set(wordList);

    const getNeighbors = (word) => {
        const neighbors = [];

        for (let i = 0; i < word.length; i++) {
            const prefix = word.slice(0, i);
            const suffix = word.slice(i + 1);

            for (let char of 'abcdefghijklmnopqrstuvwxyz') {
                if (char !== word[i]) {
                    const newWord = prefix + char + suffix;
                    if (wordSet.has(newWord)) {
                        neighbors.push(newWord);
                    }
                }
            }
        }

        return neighbors;
    }

    let startSet = new Set([beginWord]);
    let endSet = new Set([endWord]);

    let startVisited = new Set([beginWord]);
    let endVisited = new Set([endWord]);

    let level = 1;

    while (startSet.size > 0 && endSet.size > 0) {
        if (startSet.size  > endSet.size) {
            // swap to always start with smaller set
            [startSet, endSet] = [endSet, startSet];
            [startVisited, endVisited] = [endVisited, startVisited];
        }

        const nextSet = new Set();

        for (const word of startSet) {
            const neighbors = getNeighbors(word);

            for (const neighbor of neighbors) {
                if (endVisited.has(neighbor)) {
                    // found a match
                    return level + 1;
                }

                if (!startVisited.has(neighbor)) {
                    startVisited.add(neighbor);
                    nextSet.add(neighbor);
                }
            }
        }

        startSet = nextSet;
        level++;
    }

    return 0;
};
