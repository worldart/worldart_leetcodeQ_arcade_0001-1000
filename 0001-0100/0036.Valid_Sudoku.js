//15.99 RT

var isValidSudoku = function(board) {
    let rows = new Array(9).fill(0).map(() => ({}))
    let cols = new Array(9).fill(0).map(() => ({}))
    let box = new Array(9).fill(0).map(() => ({}))
    for(let r = 0; r < 9; r++){
        for(let c = 0; c < 9; c++){
            if(board[r][c] !== "."){
                let num = board[r][c]
                let boxIndex = Math.floor(r / 3) * 3 + Math.floor(c / 3)
                if(rows[r][num] || cols[c][num] || box[boxIndex][num]){
                    return false}
                rows[r][num]  = true
                cols[c][num]  = true
                box[boxIndex][num] = true
            }
        }}
    return true
};
