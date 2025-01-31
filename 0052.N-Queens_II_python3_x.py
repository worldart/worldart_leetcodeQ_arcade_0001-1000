#94.43%RT

class Solution:
    def totalNQueens(self, n: int) -> int: 
        def rec(col, horizontal, diag, anti_diag):
            if col == n: return 1
            res = 0
            for row in range(n):
                if row not in horizontal and (row + col) not in diag and (row - col) not in anti_diag:
                    horizontal[row] = True; diag[row + col] = True; anti_diag[row - col] = True;
                    res += rec(col + 1, horizontal, diag, anti_diag)
                    del horizontal[row]; del diag[row + col]; del anti_diag[row - col];
            return res
        return rec(0, {}, {}, {})
