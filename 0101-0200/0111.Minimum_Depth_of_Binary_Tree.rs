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
use std::rc::Rc;
use std::cell::RefCell;

impl Solution {
    pub fn min_depth(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        fn dfs(node: &Option<Rc<RefCell<TreeNode>>>, dsf: i32) -> i32 {
            if let Some(node) = node {
                let left = dfs(&node.borrow_mut().left.take(), dsf + 1);
                let right = dfs(&node.borrow_mut().right.take(), dsf + 1);
                if left == dsf + 1 {
                    return right;
                } else if right == dsf + 1 {
                    return left;
                }
                return std::cmp::min(left, right);
            }
            dsf
        }
        dfs(&root, 0)
    }
}
