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
    pub fn level_order_bottom(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<Vec<i32>> {
      // reverse of level order result
      let mut res: Vec<Vec<i32>> = vec![];

      let mut q: Vec<Option<Rc<RefCell<TreeNode>>>> = vec![];
      q.push(root);
      while !q.is_empty() {
        let mut nq: Vec<Option<Rc<RefCell<TreeNode>>>> = vec![];
        let mut cur_level: Vec<i32> = vec![];
        while !q.is_empty() {
          if let Some(first_item) = q.remove(0) {
            cur_level.push(first_item.borrow().val);
            nq.push(first_item.borrow().left.clone());
            nq.push(first_item.borrow().right.clone());
          }
        }
        if !cur_level.is_empty() {
            res.push(cur_level);
        }
        
        q = nq;
      }
      res.reverse();
      res
    }
}
