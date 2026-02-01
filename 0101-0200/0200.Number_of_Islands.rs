//12ms






impl Solution {
    pub fn num_islands(mut grid: Vec<Vec<char>>) -> i32 {
        let mut count = 0;
        let mut stack = vec![];
        let (m, n) = (grid.len(), grid[0].len());

        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == '1' {
                    stack.push((i, j));
                    while let Some((r, c)) = stack.pop() {
                        if r < m && c < n && grid[r][c] == '1' {
                            grid[r][c] = '0';
                            for rc in [0, 1, 0, !0, 0].windows(2) {
                                stack.push((r.wrapping_add(rc[0]), c.wrapping_add(rc[1])));
                            }
                        }
                    }
                    count += 1;
                }
            }
        }

        count
    }
}






//9ms







impl Solution {
    pub fn num_islands(grid: Vec<Vec<char>>) -> i32 {
        let m = grid.len() as usize;
        let n = grid[0].len() as usize;
        let mut memo = vec![vec![false; n]; m];
        let mut count = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == '1' && !memo[i][j] {
                    count += 1;
                    (Self::dfs(i, j, m, n, &grid, &mut memo));
                }
            }
        }
        count
    }
    pub fn dfs(
        i: usize,
        j: usize,
        m: usize,
        n: usize,
        grid: &Vec<Vec<char>>,
        memo: &mut Vec<Vec<bool>>,
    ) {
        if memo[i][j] || grid[i][j] == '0' {
            return;
        }
        memo[i][j] = true;
        let dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];
        for d in &dirs {
            let next_i = i as i32 + d[0];
            let next_j = j as i32 + d[1];
            if next_i >= 0 && next_i < m as i32 && next_j >= 0 && next_j < n as i32 {
                let ni = next_i as usize;
                let nj = next_j as usize;
                Self::dfs(ni, nj, m, n, grid, memo);
            }
        }
    }
}






//8ms






use std::collections::VecDeque;
impl Solution {
    pub fn num_islands(grid: Vec<Vec<char>>) -> i32 {
        const DIR4: [(i32, i32); 4] = [(-1, 0), (1, 0), (0, -1), (0, 1)];
        let rows = grid.len();
        let cols = grid[0].len();
        let mut grid = grid;
        let mut queue = VecDeque::new();
        let mut total = 0;

        for i in 0..rows {
            for j in 0..cols {
                if grid[i][j] == '1' {
                    total += 1;
                    grid[i][j] = '0';
                    queue.push_back((i, j));

                    while let Some((r, c)) = queue.pop_front() {
                        for (dr, dc) in DIR4 {
                            let nr = r as i32 + dr;
                            let nc = c as i32 + dc;
                            if nr >= 0
                                && nr < grid.len() as i32
                                && nc >= 0
                                && nc < grid[0].len() as i32
                            {
                                let (nr, nc) = (nr as usize, nc as usize);
                                if grid[nr][nc] == '1' {
                                    grid[nr][nc] = '0';
                                    queue.push_back((nr, nc));
                                }
                            }
                        }
                    }
                }
            }
        }
        total
    }
}






