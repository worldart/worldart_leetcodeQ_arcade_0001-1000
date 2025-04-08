//54.77% RT

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Boolean>[] rows = new HashMap[9];
        HashMap<Character, Boolean>[] cols = new HashMap[9];
        HashMap<Character, Boolean>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();}
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    char num = board[r][c];
                    int boxIndex = (r / 3) * 3 + (c / 3);
                    if (rows[r].getOrDefault(num, false) || cols[c].getOrDefault(num, false) || boxes[boxIndex].getOrDefault(num, false)) {
                        return false;}
                    rows[r].put(num, true);
                    cols[c].put(num, true);
                    boxes[boxIndex].put(num, true);
                }
            }
        }
        return true;
    }}
