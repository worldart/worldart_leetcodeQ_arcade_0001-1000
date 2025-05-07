//29ms


/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {string[][]}
 */
var findLadders = function(beginWord, endWord, wordList) {
    let min = Number.MAX_SAFE_INTEGER;
    const wordSet = new Set(wordList);
    const A_CODE = 'a'.charCodeAt(0);
    // Exclude beginWord if in wordList
    wordSet.delete(beginWord);
    // Store each step's possbile words from start.
    let usedWords = [new Set([beginWord])];
    let hasAns = false;
    // Each loop we try to reach out for more words from last step
    while (wordSet.size) {
        let usingWords = new Set();
        for (let fromWord of usedWords[usedWords.length - 1]) {
            for (let toWord of wordSet) {
                if (convertible(fromWord, toWord)) {
                    usingWords.add(toWord);
                    // Used word should not be reached again (not shortest path)
                    wordSet.delete(toWord);
                }
            }
        }
        
        if (usingWords.has(endWord)) {
            // If we reached to end word, we can start to gen answer from prev steps.
            hasAns = true;
            break;
        } else if (usingWords.size === 0) {
            // If we're not able to reach to anything, there's no solution.
            break;
        }
        usedWords.push(usingWords);
    }
    if (!hasAns) {
        return [];    
    }
    // We have all previous tried steps, and we know: Answer should be able to connect from tail to head
    // So we have init paths that only contains endWord.
    // Then backTrace compare again to contruct candidates from tail
    let paths = [[endWord]];
    usedWords = usedWords.reverse();
    for (let usingWords of usedWords) {
        let newPaths = [];
        for (let path of paths) {
            for (let usingWord of usingWords) {
                if (convertible(usingWord, path[0])) {
                    newPaths.push([usingWord].concat(path));
                }
            }
        }
        paths = newPaths;
    }
    return paths;
};

var convertible = function (lhs, rhs) {
    let c = 0;
    for (let i = 0; i < lhs.length && c < 2; i++) {
        if (lhs[i] !== rhs[i]) {
            ++c;
        }
    }
    return c === 1;   
}






//16ms




var findLadders = function(beginWord, endWord, wordList) {
    const wordSet = new Set(wordList);
    if (!wordSet.has(endWord)) return [];  // endWord must be in wordList

    wordSet.add(beginWord);

    // STEP 1: Build pattern map (one-letter wildcard patterns)
    const patternMap = new Map();
    for (let word of wordSet) {
        for (let i = 0; i < word.length; i++) {
            const pattern = word.slice(0, i) + '*' + word.slice(i + 1);
            if (!patternMap.has(pattern)) patternMap.set(pattern, []);
            patternMap.get(pattern).push(word);
        }
    }

    // STEP 2: BFS to find shortest paths layers
    const visited = new Set();
    const levels = [];
    let queue = [beginWord];
    let reached = false;

    while (queue.length && !reached) {
        levels.push(queue.slice());  // record current level
        const nextQueue = [];
        const levelVisited = new Set();

        for (let word of queue) {
            for (let i = 0; i < word.length; i++) {
                const pattern = word.slice(0, i) + '*' + word.slice(i + 1);
                const neighbors = patternMap.get(pattern) || [];

                for (let neighbor of neighbors) {
                    if (neighbor === word || visited.has(neighbor)) continue;
                    if (neighbor === endWord) reached = true;

                    if (!levelVisited.has(neighbor)) {
                        levelVisited.add(neighbor);
                        nextQueue.push(neighbor);
                    }
                }
            }
        }

        for (let word of levelVisited) visited.add(word);
        queue = nextQueue;
    }

    if (!reached) return [];  // no path found

    // STEP 3: Backtrack paths from endWord to beginWord
    let paths = [[endWord]];

    function isOneLetterDiff(w1, w2) {
        let diff = 0;
        for (let i = 0; i < w1.length && diff < 2; i++) w1[i] !== w2[i] && diff++;
        return diff === 1;
    }

    for (let level = levels.length - 1; level >= 0; level--) {
        const candidates = new Set(levels[level]);
        const newPaths = [];

        for (let path of paths) {
            const word = path[0];
            for (let cand of candidates) {
                if (isOneLetterDiff(cand, word)) {
                    newPaths.push([cand, ...path]);
                }
            }
        }

        paths = newPaths;
    }

    return paths;
};
