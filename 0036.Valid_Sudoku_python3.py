#100% RT

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [{} for _ in range(9)]
        cols = [{} for _ in range(9)]
        boxes = [{} for _ in range(9)]
        for r in range(9):
            for c in range(9):
                if board[r][c] != '.':
                    num = board[r][c]
                    box_index = (r // 3) * 3 + (c // 3)
                    if num in rows[r] or num in cols[c] or num in boxes[box_index]:
                        return False
                    rows[r][num] = True
                    cols[c][num] = True
                    boxes[box_index][num] = True
        return True
