//1ms 100%RT

const DIRECTIONS = [0, 1, 0, -1, 0];

/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
const exist = function (board, word) {
    const m = board.length;
    const n = board[0].length;
    const wordLength = word.length;

    if (wordLength > m * n) {
        return false;
    }

    const dfs = (rowIndex, columnIndex, wordIndex) => {
        if (wordIndex === wordLength) {
            return true;
        }

        const character = word[wordIndex];

        if (
            rowIndex < 0 ||
            rowIndex === m ||
            columnIndex < 0 ||
            columnIndex === n ||
            board[rowIndex][columnIndex] !== character
        ) {
            return false;
        }

        board[rowIndex][columnIndex] = '#';

        for (let index = 0; index < 4; index += 1) {
            if (
                dfs(
                    rowIndex + DIRECTIONS[index],
                    columnIndex + DIRECTIONS[index + 1],
                    wordIndex + 1
                )
            ) {
                return true;
            }
        }

        board[rowIndex][columnIndex] = character;

        return false;
    };

    const frequency = new Map();

    for (const row of board) {
        for (const character of row) {
            frequency.set(character, (frequency.get(character) ?? 0) + 1);
        }
    }

    for (const character of word) {
        if (!frequency.has(character)) {
            return false;
        }

        const characterFrequency = frequency.get(character);

        if (characterFrequency === 0) {
            return false;
        }

        frequency.set(character, characterFrequency - 1);
    }

    if (frequency.get(word[0]) > frequency.get(word.at(-1))) {
        word = word.split('').reverse().join('');
    }

    for (let rowIndex = 0; rowIndex < m; rowIndex += 1) {
        for (let columnIndex = 0; columnIndex < n; columnIndex += 1) {
            if (dfs(rowIndex, columnIndex, 0)) {
                return true;
            }
        }
    }

    return false;
};
