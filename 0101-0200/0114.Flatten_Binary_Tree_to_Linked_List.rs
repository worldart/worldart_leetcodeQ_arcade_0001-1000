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
    pub fn flatten(root: &mut Option<Rc<RefCell<TreeNode>>>) {
        let mut current = root.clone();
        
        while let Some(node_rc) = current {
            let mut node = node_rc.borrow_mut();
            
            if let Some(left_rc) = node.left.take() {
                let mut predecessor = left_rc.clone();
                
                while predecessor.borrow().right.is_some() {
                    let right_child = predecessor.borrow().right.clone();
                    predecessor = right_child.unwrap();;
                }
                predecessor.borrow_mut().right = node.right.take();
                node.right = Some(left_rc);
            }    
            current = node.right.clone();
        }        
    }
}
