//0ms


class Solution {
private: 
    void dfs(int x,int y,vector<vector<char>>& board , vector<vector<int>> & vis ){
        int n=board.size();
        int m=board[0].size();
        vis[x][y]=1;

        int delx[]={-1,0,1,0};
        int dely[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int newx=x+delx[i];
            int newy=y+dely[i];
            if(newx>=0 && newx<n && newy>=0 && newy<m && !vis[newx][newy] && board[newx][newy]=='O'){
                dfs(newx,newy,board,vis);
            }
        }

    }
public:
    void solve(vector<vector<char>>& board) {
        int n=board.size();
        int m=board[0].size();
     vector<vector<int>> vis(n,vector<int> (m,0));
     for(int i=0;i<n;i++){
        if(board[i][0]=='O'){
            dfs(i,0,board,vis);
        }
        if(board[i][m-1]=='O'){
            dfs(i,m-1,board,vis);
        }
     }
     for(int i=0;i<m;i++){
        if(board[0][i]=='O'){
            dfs(0,i,board,vis);
        }
        if(board[n-1][i]=='O'){
            dfs(n-1,i,board,vis);
        }
     }
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(board[i][j]=='O' && vis[i][j]==0){
                board[i][j]='X';
            }
        }
    }
    }
};






//1ms





class Solution {
public:
void dfs(int row,int col, vector<vector<char>>&board , vector<vector<int>>&vis, int delrow[],
int delcol[]){
    int n=board.size();
    int m=board[0].size();
    vis[row][col]=1;
    for(int i=0;i<4;i++){
        int nrow=row+delrow[i];
        int ncol=col+delcol[i];
        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0
         && board[nrow][ncol]=='O'){
            dfs(nrow,ncol,board,vis,delrow,delcol);
        }
    }
}
    vector<vector<char>>solve(vector<vector<char>>& board) {
        int n=board.size();
        int m=board[0].size();
        int delrow[]={-1,0,+1,0};
        int delcol[]={0,1,0,-1};
        vector<vector<int>>vis(n,vector<int>(m,0));
        for(int j=0;j<m;j++){
            if(!vis[0][j] && board[0][j]=='O'){
                dfs(0,j,board,vis,delrow,delcol);
            }
            if(!vis[n-1][j] && board[n-1][j]=='O'){
                dfs(n-1,j,board,vis,delrow,delcol);
            }
        }
         for(int j=0;j<n;j++){
            if(!vis[j][0] && board[j][0]=='O'){
                dfs(j,0,board,vis,delrow,delcol);
            }
            if(!vis[j][m-1] && board[j][m-1]=='O'){
                dfs(j,m-1,board,vis,delrow,delcol);
        }
         }
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O')board[i][j]='X';
            }
         }
         return board;
    }
};

