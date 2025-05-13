//2ms





class Solution {
    private void dfs(int x, int y, char[][] board, boolean[][] vis) {
        int n = board.length;
        int m = board[0].length;
        vis[x][y] = true;

        int[] delx = {-1, 0, 1, 0};
        int[] dely = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newx = x + delx[i];
            int newy = y + dely[i];
            if (newx >= 0 && newx < n && newy >= 0 && newy < m &&
                !vis[newx][newy] && board[newx][newy] == 'O') {
                dfs(newx, newy, board, vis);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        // Left and Right Borders
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board, vis);
            if (board[i][m - 1] == 'O') dfs(i, m - 1, board, vis);
        }

        // Top and Bottom Borders
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') dfs(0, j, board, vis);
            if (board[n - 1][j] == 'O') dfs(n - 1, j, board, vis);
        }

        // Flip unvisited 'O' to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}







//0ms








class Solution {
    private static char CAP = 'X';
    private static char UNCAP = 'O';
    private static char DCAP = 'D';
    private static int n, m;

    private static boolean isValidCoord(int i, int j) {
        return i > -1 && i < n && j > -1 && j < m; 
    }

    private static void markDCap(int i, int j, char[][] board) {
        if(!isValidCoord(i, j)) return;
        if(board[i][j] == DCAP || board[i][j] == CAP) return;

        board[i][j] = DCAP;

        markDCap(i - 1, j, board);
        markDCap(i + 1, j, board);
        markDCap(i, j - 1, board);
        markDCap(i, j + 1, board);
    }

    private static void replaceAll(char src, char tar, char[][] board) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == src) {
                    board[i][j] = tar;
                }
            }
        }
    }

    public void solve(char[][] board) {
        n = board.length; m = board[0].length;
        
        for(int i = 0; i < n; i++) {
            markDCap(i, 0, board);
            markDCap(i, m - 1, board);
        }

        for(int j = 0; j < m; j++) {
            markDCap(0, j, board);
            markDCap(n - 1, j, board);
        }

        replaceAll(UNCAP, CAP, board);
        replaceAll(DCAP, UNCAP, board);
    }
}

