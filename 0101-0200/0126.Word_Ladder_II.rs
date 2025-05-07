//1ms


use std::collections::HashMap;
use std::collections::HashSet;

#[derive(Hash, PartialEq, Eq)]
struct PrefixSuffix<'a> {
    prefix: &'a [u8],
    suffix: &'a [u8],
}

type Adj<'a> = HashMap<PrefixSuffix<'a>, Vec<usize>>;

fn compute_adj<'a>(words: &[&'a [u8]]) -> Adj<'a> {
    let mut adj = Adj::new();
    for (i, word) in words.iter().enumerate() {
        for j in 0..word.len() {
            let prefix_suffix = PrefixSuffix {
                prefix: &word[0..j],
                suffix: &word[j + 1..],
            };
            adj.entry(prefix_suffix).or_default().push(i);
        }
    }
    adj
}

type Next = Vec<HashSet<usize>>;

fn bfs(adj: &Adj, words: &[&[u8]], begin_index: usize, end_index: usize) -> Option<Next> {
    let mut next: Next = vec![HashSet::new(); words.len()];
    let mut visited = vec![false; words.len()];

    let mut level = HashSet::new();
    level.insert(end_index);

    let mut next_level = HashSet::new();

    while !level.is_empty() {
        for i in &level {
            visited[*i] = true;
        }
        if visited[begin_index] {
            return Some(next);
        }
        for i in &level {
            let word = words[*i];
            for j in 0..word.len() {
                let prefix_suffix = PrefixSuffix {
                    prefix: &word[0..j],
                    suffix: &word[j + 1..],
                };
                if let Some(l) = adj.get(&prefix_suffix) {
                    for k in l {
                        if !visited[*k] {
                            next_level.insert(*k);
                            next[*k].insert(*i);
                        }
                    }
                }
            }
        }
        std::mem::swap(&mut level, &mut next_level);
        next_level.clear();
    }

    None
}

fn dfs(
    next: &Next,
    begin: usize,
    end: usize,
    current: &mut Vec<usize>,
    result: &mut Vec<Vec<usize>>,
) {
    current.push(begin);
    if begin == end {
        result.push(current.clone());
    } else {
        for i in &next[begin] {
            dfs(next, *i, end, current, result);
        }
    }
    current.pop();
}

impl Solution {
    pub fn find_ladders(
        begin_word: String,
        end_word: String,
        word_list: Vec<String>,
    ) -> Vec<Vec<String>> {
        let begin_word = begin_word.into_bytes();
        let end_word = end_word.into_bytes();
        let word_list: Vec<_> = word_list.into_iter().map(|s| s.into_bytes()).collect();
        let mut word_list: Vec<_> = word_list.iter().map(|v| v.as_slice()).collect();
        let begin_index = if let Some(index) = word_list.iter().position(|item| *item == begin_word)
        {
            index
        } else {
            word_list.push(&begin_word);
            word_list.len() - 1
        };

        if let Some(end_index) = word_list.iter().position(|item| *item == end_word) {
            let adj = compute_adj(&word_list);
            if let Some(next) = bfs(&adj, &word_list, begin_index, end_index) {
                let mut result = Vec::new();
                let mut current = Vec::new();
                dfs(&next, begin_index, end_index, &mut current, &mut result);
                result
                    .into_iter()
                    .map(|v| {
                        v.into_iter()
                            .map(|i| String::from_utf8(word_list[i].to_vec()).unwrap())
                            .collect()
                    })
                    .collect()
            } else {
                Vec::new()
            }
        } else {
            Vec::new()
        }
    }
}





//0ms




use std::collections::{HashMap, HashSet, VecDeque};

impl Solution {
    pub fn find_ladders(
        begin_word: String,
        end_word: String,
        word_list: Vec<String>,
    ) -> Vec<Vec<String>> {
        let begin_bytes = begin_word.as_bytes().to_vec();
        let end_bytes = end_word.as_bytes().to_vec();
        
        // Check if end word exists in the list
        if !word_list.iter().any(|w| w.as_bytes() == end_bytes) {
            return vec![];
        }
        
        // Build word list as bytes for faster processing
        let mut words_bytes: Vec<Vec<u8>> = word_list.iter()
            .map(|w| w.as_bytes().to_vec())
            .collect();
            
        // Add begin_word if not already in list
        let begin_idx = if let Some(pos) = words_bytes.iter().position(|w| *w == begin_bytes) {
            pos
        } else {
            words_bytes.push(begin_bytes.clone());
            words_bytes.len() - 1
        };
        
        let end_idx = words_bytes.iter().position(|w| *w == end_bytes).unwrap();
        
        // Build graph using pattern-based approach
        let mut pattern_map: HashMap<Vec<u8>, Vec<usize>> = HashMap::new();
        for (i, word) in words_bytes.iter().enumerate() {
            for j in 0..word.len() {
                let mut pattern = word.clone();
                pattern[j] = 0; // Use 0 as wildcard
                pattern_map.entry(pattern).or_default().push(i);
            }
        }
        
        // Perform BFS to find shortest paths
        let mut queue = VecDeque::new();
        queue.push_back(begin_idx);
        
        let mut visited = vec![false; words_bytes.len()];
        visited[begin_idx] = true;
        
        let mut parents: Vec<Vec<usize>> = vec![vec![]; words_bytes.len()];
        let mut found = false;
        
        // BFS to build parent relationships
        while !queue.is_empty() && !found {
            let level_size = queue.len();
            let mut level_visited = vec![false; words_bytes.len()];
            
            for _ in 0..level_size {
                let current = queue.pop_front().unwrap();
                
                if current == end_idx {
                    found = true;
                }
                
                if found {
                    continue;
                }
                
                let word = &words_bytes[current];
                for j in 0..word.len() {
                    let mut pattern = word.clone();
                    pattern[j] = 0;
                    
                    if let Some(neighbors) = pattern_map.get(&pattern) {
                        for &next in neighbors {
                            if next != current && !visited[next] {
                                if !level_visited[next] {
                                    queue.push_back(next);
                                    level_visited[next] = true;
                                }
                                parents[next].push(current);
                            }
                        }
                    }
                }
            }
            
            // Mark all nodes in this level as visited
            for i in 0..words_bytes.len() {
                if level_visited[i] {
                    visited[i] = true;
                }
            }
        }
        
        if !found {
            return vec![];
        }
        
        // Build paths using DFS
        let mut result = Vec::new();
        let mut path = Vec::new();
        Self::build_paths(end_idx, begin_idx, &parents, &mut path, &mut result);
        
        // Convert indices to strings
        result.into_iter()
            .map(|p| {
                p.into_iter().rev().map(|idx| {
                    if idx == begin_idx {
                        begin_word.clone()
                    } else if idx == end_idx {
                        end_word.clone()
                    } else {
                        String::from_utf8(words_bytes[idx].clone()).unwrap()
                    }
                }).collect()
            })
            .collect()
    }
    
    fn build_paths(
        current: usize,
        target: usize,
        parents: &[Vec<usize>],
        path: &mut Vec<usize>,
        result: &mut Vec<Vec<usize>>,
    ) {
        path.push(current);
        
        if current == target {
            result.push(path.clone());
        } else {
            for &parent in &parents[current] {
                Self::build_paths(parent, target, parents, path, result);
            }
        }
        
        path.pop();
    }
}



