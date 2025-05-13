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
    pub fn sum_numbers(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        fn dfs(node: &Option<Rc<RefCell<TreeNode>>>, mut sum: i32) -> i32 {
            if let Some(node_rc) = node {
                let node_ref = node_rc.borrow();
                sum = (sum * 10) + node_ref.val;
                if node_ref.left.is_none() && node_ref.right.is_none() {
                    sum
                } else {
                    dfs(&node_ref.left, sum) + dfs(&node_ref.right, sum)
                }
            } else {
                0
            }
        }
        dfs(&root, 0)
    }
}
