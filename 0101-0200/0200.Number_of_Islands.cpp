//20ms




class Solution {
private:
    void dfs(int i, int j, vector<vector<char>>& grid) {
        grid[i][j] = '0';
        if (i != 0 && grid[i - 1][j] == '1') {
            dfs(i - 1, j, grid);
        }
        if (i != grid.size() - 1 && grid[i + 1][j] == '1') {
            dfs(i + 1, j, grid);
        }
        if (j != 0 && grid[i][j - 1] == '1') {
            dfs(i, j - 1, grid);
        }
        if (j != grid[0].size() - 1 && grid[i][j + 1] == '1') {
            dfs(i, j + 1, grid);
        }
    }
public:
    int numIslands(vector<vector<char>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        int island = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    dfs(i, j, grid);
                }
            }
        }
        return island;
    }
};






//29ms






class Solution {
public:
    void dfs(vector<vector<char>>& grid, int i, int j) {
        int n = grid.size();
        int m = grid[0].size();

        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0')
            return;

        grid[i][j] = '0'; // mark visited

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    int numIslands(vector<vector<char>>& grid) {
        int count = 0;

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
};





//19ms





class Solution {
public:
    int find(vector<int>& parent, int i) {
        while (parent[i] >= 0) {
            if (parent[parent[i]] >= 0) {
                parent[i] = parent[parent[i]];
            }
            i = parent[i];
        }
        return i;
    }
    bool merge(vector<int>& parent, int root_i, int root_j) {
        if (root_i == root_j) return 0;
        if (parent[root_i] < parent[root_j]) {
            add_child(parent, root_i, root_j);
        } else {
            add_child(parent, root_j, root_i);
        }
        return 1;
    }
    void add_child(vector<int>& parent, int parent_root, int child_root) {
        parent[parent_root] += parent[child_root];
        parent[child_root] = parent_root; 
    }
    int numIslands(vector<vector<char>>& grid) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);

        const int n = grid.size();
        const int m = grid[0].size();
        vector<int> parent(n * m, -1);
        int count = 0;
        for (int i = 0; i < n; ++i) {
            const int row_offset = i * m;
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    count += 1;
                    const int id = row_offset + j;
                    if (i+1 < n && grid[i+1][j] == '1') {
                        // add_child(parent, find(parent, id), id+m);
                        parent[id+m] = id;
                        count -= 1;
                    }
                    if (j+1 < m && grid[i][j+1] == '1') {
                        count -= merge(parent, find(parent, id), find(parent, id+1));
                    }
                }
            }
        }
        return count;
    }
};
