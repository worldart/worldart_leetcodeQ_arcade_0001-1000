//0ms

impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        let mut word_chars = word.chars().collect::<Vec<_>>();
        let mut counter = std::collections::HashMap::new();
        for letter in word.chars() {
            *counter.entry(letter).or_insert(0) += 1;
        }
        if counter[word_chars.first().unwrap()] >= counter[word_chars.last().unwrap()] {
            word_chars = word.chars().rev().collect();
        }
        let word_length = word_chars.len();
        let m = board.len();
        let n = board[0].len();
        let mut visited = vec![vec![false; n]; m];
        for i in 0..m {
            for j in 0..n {
                if board[i][j] != word_chars[0] {
                    continue;
                }
                let mut path = vec![(i, j, 0)];
                while !path.is_empty() {
                    let path_length = path.len();
                    if path_length == word_length {
                        return true;
                    }
                    let (x, y, status) = path[path_length - 1];
                    let next_char = word_chars[path_length];
                    match status {
                        0 => {
                            visited[x][y] = true;
                            path[path_length - 1].2 = 1;
                            if x > 0 && board[x - 1][y] == next_char && !visited[x - 1][y] {
                                path.push((x - 1, y, 0));
                            }
                        }
                        1 => {
                            path[path_length - 1].2 = 2;
                            if x < m - 1 && board[x + 1][y] == next_char && !visited[x + 1][y] {
                                path.push((x + 1, y, 0));
                            }
                        }
                        2 => {
                            path[path_length - 1].2 = 3;
                            if y > 0 && board[x][y - 1] == next_char && !visited[x][y - 1] {
                                path.push((x, y - 1, 0));
                            }
                        }
                        3 => {
                            path[path_length - 1].2 = 4;
                            if y < n - 1 && board[x][y + 1] == next_char && !visited[x][y + 1] {
                                path.push((x, y + 1, 0));
                            }
                        }
                        _ => {
                            visited[x][y] = false;
                            path.pop();
                        }
                    }
                }
            }
        }
        false
    }
}
