#5ms


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:return
        rows,cols=len(board),len(board[0])
        def dfs(r,c):
            if r<0 or r >=rows or c<0 or c>=cols or board[r][c]!='O':
                return 
            board[r][c]='M'
            dfs(r-1,c)
            dfs(r+1,c)
            dfs(r,c-1)
            dfs(r,c+1)
        for i in range(rows):
            if board[i][0]=='O':
                dfs(i,0)
            if board[i][cols-1]=='O':
                dfs(i,cols-1)
        for j in range(cols):
            if board[0][j]=='O':
                dfs(0,j)
            if board[rows-1][j]=='O':
                dfs(rows-1,j)
        for i in range(rows):
            for j in range(cols):
                if board[i][j]=='O':
                    board[i][j]='X'
                elif board[i][j]=='M':
                    board[i][j]='O'




#0ms




class Solution:
    def solve(self, mat: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m, n = len(mat), len(mat[0])
        def dfs(i, j):
            if i<0 or j < 0 or i>=m or j>=n or mat[i][j]!='O':
                return
            mat[i][j] = 'T'
            dfs(i-1, j)
            dfs(i+1, j)
            dfs(i, j-1)
            dfs(i, j+1)

        for i in range(m):
            dfs(i, 0)
            dfs(i, n-1)
        for j in range(n):
            dfs(0, j)
            dfs(m-1, j)
        for i in range(m):
            for j in range(n):
                if mat[i][j]=="O":
                    mat[i][j] = "X"
                elif mat[i][j] == "T":
                    mat[i][j] = "O"        

#55ms




class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def is_palindrome(sub):
            return sub == sub[::-1]

        def backtrack(start, path):
            if start == len(s):
                partitions.append(path[:])
                return
            
            for end in range(start + 1, len(s) + 1):
                if is_palindrome(s[start:end]):
                    path.append(s[start:end])
                    backtrack(end, path)
                    path.pop()

        partitions = []
        backtrack(0, [])
        return partitions
