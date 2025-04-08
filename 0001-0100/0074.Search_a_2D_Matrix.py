#0ms


class Solution(object):
    def searchMatrix(self, matrix, target):
        low = 0
        high = (len(matrix) * len(matrix[0])) -1

        while low <= high:
            mid = (low+high)//2

            row = mid // len(matrix[0])
            col = mid % len(matrix[0])

            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                low = mid+1
            else : high = mid - 1
        return False
        
