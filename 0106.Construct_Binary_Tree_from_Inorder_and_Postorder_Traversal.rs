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
use std::collections::HashMap;

impl Solution {
    pub fn build_tree(inorder: Vec<i32>, postorder: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        fn helper(
            postorder: &[i32],
            inorder_map: &HashMap<i32, usize>,
            q: usize
        ) -> Option<Rc<RefCell<TreeNode>>> {
            let [rest @ .., val] = postorder else { return None; };
            let inorder_idx = inorder_map[val];
            let i = inorder_idx - q;
            Some(Rc::new(RefCell::new(TreeNode {
                val: *val,
                left: helper(&rest[..i], inorder_map, q),
                right: helper(&rest[i..], inorder_map, inorder_idx + 1),
            })))
        }

        helper(&postorder, &inorder.into_iter().enumerate().map(|(i, v)| (v, i)).collect(), 0)
    }
}
