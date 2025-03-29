//0ms



// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
// 
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }
use std::collections::VecDeque;
use std::rc::Rc;
use std::cell::RefCell;
impl Solution {
    pub fn level_order(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<Vec<i32>> {
        if root.is_none() { return vec![]; }
        let mut queue = VecDeque::new();
        let mut result: Vec<Vec<i32>> = Vec::new();
        queue.push_back(root.unwrap());
        
        while !queue.is_empty() {
            let level_size = queue.len();
            let mut level: Vec<i32> = Vec::new();
            
            for _ in 0..level_size {
                let node = queue.pop_front().unwrap();
                let node_ref = node.borrow();
                level.push(node_ref.val);
                
                if node_ref.left.is_some() {
                    queue.push_back(node_ref.left.clone().unwrap());
                }
                if node_ref.right.is_some() {
                    queue.push_back(node_ref.right.clone().unwrap());
                }                
            }
            result.push(level);
        }
        result        
    }
}
