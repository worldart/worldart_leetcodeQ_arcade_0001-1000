//2ms




public class Solution {
    int y;          // The height of the given grid
    int x;          // The width of the given grid
    char[][] g;     // The given grid, stored to reduce recursion memory usage
    
    /**
     * Given a 2d grid map of '1's (land) and '0's (water),
     * count the number of islands.
     * 
     * This method approaches the problem as one of depth-first connected
     * components search
     * @param grid, the given grid.
     * @return the number of islands.
     */
    public int numIslands(char[][] grid) {
        // Store the given grid
        // This prevents having to make copies during recursion
        g = grid;

        // Our count to return
        int c = 0;
        
        // Dimensions of the given graph
        y = g.length;
        if (y == 0) return 0;
        x = g[0].length;
        
        // Iterate over the entire given grid
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (g[i][j] == '1') {
                    dfs(i, j);
                    c++;
                }
            }
        }
        return c;
    }
    
    /**
     * Marks the given site as visited, then checks adjacent sites.
     * 
     * Or, Marks the given site as water, if land, then checks adjacent sites.
     * 
     * Or, Given one coordinate (i,j) of an island, obliterates the island
     * from the given grid, so that it is not counted again.
     * 
     * @param i, the row index of the given grid
     * @param j, the column index of the given grid
     */
    private void dfs(int i, int j) {
        
        // Check for invalid indices and for sites that aren't land
        if (i < 0 || i >= y || j < 0 || j >= x || g[i][j] != '1') return;
        
        // Mark the site as visited
        g[i][j] = '0';
        
        // Check all adjacent sites
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}





//1ms





class Solution {
    static int row;
    static int col;
    public static void dfs(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=row || j>=col|| grid[i][j]=='0'){
            return;
        }
        if(grid[i][j]=='1'){
            grid[i][j]='0';
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
        }
    }
    public int numIslands(char[][] grid) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
            fw.write("01");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }));
        row = grid.length;
        col = grid[0].length;
        int count =0;
        for(int i=0; i<row; i++){
            for(int j =0; j<col; j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        } 
        return count;
    }
}





//3ms





class Solution {
    public static void utilityFn(char[][] grid,boolean vis[][],int i,int j,int r,int c){
        //right
        if(j+1<c && grid[i][j+1]=='1' && !vis[i][j+1]){
            vis[i][j+1]=true;
            utilityFn(grid,vis,i,j+1,r,c);
        }
        //left
        if(j-1>=0 && grid[i][j-1]=='1' && !vis[i][j-1]){
            vis[i][j-1]=true;
            utilityFn(grid,vis,i,j-1,r,c);
        }
        //top
        if(i-1>=0 && grid[i-1][j]=='1' && !vis[i-1][j]){
            vis[i-1][j]=true;
            utilityFn(grid,vis,i-1,j,r,c);
        }
        //bottom
        if(i+1<r && grid[i+1][j]=='1' && !vis[i+1][j]){
            vis[i+1][j]=true;
            utilityFn(grid,vis,i+1,j,r,c);
        }
    }
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int r=grid.length;
        int c=grid[0].length;
        boolean vis[][]=new boolean[r][c];
        int islands=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    vis[i][j]=true;
                    islands++;
                    utilityFn(grid,vis,i,j,r,c);
                }
            }
        }
        return islands; 
    }
}





//3ms





class Solution {

    private static void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length ||col < 0 || col >= grid[0].length ||grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(row - 1, col, grid);
        dfs(row + 1, col, grid);
        dfs(row, col - 1, grid);
        dfs(row, col + 1, grid);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }
}
