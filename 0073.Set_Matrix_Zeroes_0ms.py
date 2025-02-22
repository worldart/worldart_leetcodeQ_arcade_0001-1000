#0ma


class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        rowLen = len(matrix)
        colLen = len(matrix[0])
        rowZ = [1] * rowLen
        colZ = [1] * colLen

        for x, row in enumerate(matrix):
            for y, val in enumerate(row):
                if val == 0:
                    rowZ[x] = 0
                    colZ[y] = 0

        for x in range(rowLen):
            if rowZ[x] == 0:
                matrix[x] = [0]*colLen
                continue;
            for y in range(colLen):
                if colZ[y] == 0:
                    matrix[x][y] = 0
        
        return

        
