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
use std::cell::RefCell;
use std::rc::Rc;
impl Solution {
    pub fn path_sum(root: Option<Rc<RefCell<TreeNode>>>, target_sum: i32) -> Vec<Vec<i32>> {
        let mut result = Vec::new();
        Self::dfs(target_sum, root.as_ref(), &mut Vec::new(), &mut result);
        result
    }
    fn dfs(mut t: i32, root: Option<&Rc<RefCell<TreeNode>>>, p: &mut Vec<i32>, result: &mut Vec<Vec<i32>>) {
        let Some(node) = root.map(|n| n.borrow()) else {
            return;
        };
        t -= node.val;
        p.push(node.val);
        if t == 0 && node.left.is_none() && node.right.is_none() {
            result.push(p.clone());
        } else {
            Self::dfs(t, node.left.as_ref(), p, result);
            Self::dfs(t, node.right.as_ref(), p, result);
        }
        p.pop();
    }
}
