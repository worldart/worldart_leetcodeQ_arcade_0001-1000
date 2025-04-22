#0mw


# numRows = 5
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if numRows == 1:
            return [[1]]
        
        pascal_triangle = [[1]] # [[1], [1, 1], [1,2,1], [1, 3, 3, 1], [1, 4, 6, 4, 1 ] ]
        
        currentRow = 0 # 4
        while len(pascal_triangle) != numRows: # 4 != 5
            currentlength = len(pascal_triangle[currentRow]) # 4
            newRow = [] # [1, 4, 6, 4, 1 ]
                
            newRow.append(pascal_triangle[currentRow][0]) 
            for r in range(1,len(pascal_triangle[currentRow])): 
                value = pascal_triangle[currentRow][r-1] + pascal_triangle[currentRow][r] # 2
                newRow.append(value)
            
            newRow.append(pascal_triangle[currentRow][-1]) 
            pascal_triangle.append(newRow)
            currentRow += 1
              
        
        return pascal_triangle
        
        
