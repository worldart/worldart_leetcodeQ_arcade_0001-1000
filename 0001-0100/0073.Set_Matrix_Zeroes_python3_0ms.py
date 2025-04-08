#0ms

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        rows, cols = len(matrix), len(matrix[0])

        zeroRows, zeroCols =  set(), set()

        for r in range(rows):
            for c in range(cols):
                if matrix[r][c] == 0:
                    zeroRows.add(r)
                    zeroCols.add(c)

        for row in zeroRows:
            for col in range(cols):
                matrix[row][col] = 0
        
        for col in zeroCols:
            for row in range(rows):
                matrix[row][col] = 0
        

        
        
