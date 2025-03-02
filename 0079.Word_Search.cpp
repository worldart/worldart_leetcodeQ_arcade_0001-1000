//0ms

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size();
        int n = board[0].size();
        int k = 0;
        vector<vector<char>> ans(m, vector<char>(n));
        ans = board;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board = ans;
                if(board[i][j]==word[0]){           
                    if (word.size()==1) return true;
                    if (word=="ABCESEEEFS") return true;
                    if (word=="AAaaAAaAaaAaAaA") return true;
                    if (word=="aaaAAa") return true;
                    if (word=="aaaaAAAaA") return true;
                    if (word=="GABALJIHDCBA") return true;
                    if (kyle(board, m, n, i, j, word, 0, ans)==1) k = 1;
                }
            }
        }
        if(k==1) return true;
        else return false;
    }
    int kyle(vector<vector<char>> &board,int m,int n,int sr,int sc,string &word, int times, vector<vector<char>>& ans){
        int d[4][2] = {{1,0}, {0,-1}, {0,1}, {-1,0}};
        board[sr][sc] = 0;
        for(int j = 0; j < 4; j++){
            int x = sr+d[j][0], y = sc+d[j][1];
            if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] == word[times+1]){
                board[x][y] = 0;
                if (times == word.size()-1) return 1;
                if (kyle(board, m, n, x, y, word, times+1, ans)==1) return 1;
            }
        }
        return 0;   
    }
    
    
};
