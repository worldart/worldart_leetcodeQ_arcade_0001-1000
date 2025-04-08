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
    pub fn recover_tree(root: &mut Option<Rc<RefCell<TreeNode>>>) {
        let mut stack = vec![];
        let mut curr = root.clone();
        let mut x = None;
        let mut y = None;
        let mut pred: Option<Rc<RefCell<TreeNode>>> = None;

        while !(stack.is_empty() && curr.is_none()) {
            while let Some(node) = curr {
                curr = node.borrow_mut().left.clone();
                stack.push(node);
            }
            if let Some(node) = stack.pop() {
                if let Some(p) = pred {
                    if p.borrow_mut().val > node.borrow_mut().val {
                        y = Some(node.clone());
                        if x.is_none() {
                            x = Some(p);
                        } else {
                            break;
                        }
                    }
                }
                pred = Some(node.clone());
                curr = node.borrow_mut().right.clone();
            }
        }

        let mut x = x.as_ref().unwrap().borrow_mut();
        let mut y = y.as_ref().unwrap().borrow_mut();
        let temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
