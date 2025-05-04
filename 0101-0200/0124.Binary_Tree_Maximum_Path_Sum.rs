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
use std::{
	rc::Rc,
	cell::RefCell,
	i32,
	cmp,
};

impl Solution {
    pub fn max_path_sum(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let mut result = i32::MIN;
        
		Self::dfs(&root, &mut result);
        
		return result;
    }

    fn dfs(root: &Option<Rc<RefCell<TreeNode>>>, result: &mut i32) -> i32 {
        if let Some(n) = root {
            let node = n.borrow();

            let left = cmp::max(0, Self::dfs(&node.left, result));
            let right = cmp::max(0, Self::dfs(&node.right, result));

            *result = cmp::max(*result, node.val + left + right);
            
			return node.val + cmp::max(left, right);
        } else {
            return 0;
        }
    }
}
