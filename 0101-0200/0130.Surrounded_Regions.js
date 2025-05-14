//8ms




/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve = function(board) {
    const rows = board.length;
    const cols = board[0].length;
    if (rows === 0 || cols === 0) { return; }
    
    for (let i = 0; i < rows; i++) {
        dfs(board, i, 0);
        dfs(board, i, cols - 1);
    }
    for (let j = 0; j < cols; j++) {
        dfs(board, 0, j);
        dfs(board, rows - 1, j);
    }
    
    
    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < cols; j++) {
            if (board[i][j] === 'O') {
                board[i][j] = 'X';
            }
            else if (board[i][j] === '#') {
                board[i][j] = 'O';
            }
        }
    }
    
    function dfs(board, i, j) {
        const rows = board.length;
        const cols = board[0].length;
        
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }    
};





//10ms







/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve = function(board) {
    // capture unsurrounded regions
    // capture surrounded regions
    // uncapture unsurrounded regions

    let rows = board.length
    let columns = board[0].length

    function traverse(i, j) {
        if (i < 0 || j < 0 || i == rows || j == columns || board[i][j] != "O") return
        board[i][j] = "T"
        traverse(i - 1, j) // up
        traverse(i, j + 1) // right
        traverse(i + 1, j) // down
        traverse(i, j - 1) // left
    }

    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < columns; j++) {
            if (board[i][j] == "O") {
                if (i == 0 || j == 0 || i == rows - 1 || j == columns - 1) {
                    traverse(i, j)
                }
            }
        }
    }

    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < columns; j++) {
            if (board[i][j] == "O") {
                board[i][j] = "X"
            }
        }
    }

    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < columns; j++) {
            if (board[i][j] == "T") {
                board[i][j] = "O"
            }
        }
    }
};
