#97.84%RT

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board=[]
        ans=[]
        lrow=[0]*n
        upperd=[0]*(2*n-1)
        lowerd=[0]*(2*n-1)
        self.solve(0,board,ans,lrow,lowerd,upperd,n)
        return ans
    def solve(self,col,board,ans,lrow,lowerd,upperd,n):
        if col==n:
            ans.append(board[::])
            return
        for row in range(n):
            if lrow[row]==0 and upperd[n-1+col-row]==0 and lowerd[row+col]==0:
                board.append("."*(row)+"Q"+"."*(n-row-1))
                lrow[row]=1
                upperd[n-1+col-row]=1
                lowerd[row+col]=1
                self.solve(col+1,board,ans,lrow,lowerd,upperd,n)
                board.pop()
                lrow[row]=0
                upperd[n-1+col-row]=0
                lowerd[row+col]=0
