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

    pub fn postorder_traversal(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        root.as_ref().map_or(vec![], |r| { let r = r.borrow();
            [&Self::postorder_traversal(r.left.clone())[..], 
             &Self::postorder_traversal(r.right.clone())[..], &[r.val]].concat()
        })
    }
}





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
    pub fn postorder_traversal(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
                fn dfs(tree: &Option<Rc<RefCell<TreeNode>>>, result:&mut Vec<i32>) {
            if let Some(node) = tree {
                let node_ref = node.borrow();
                dfs(&node_ref.left, result);
                dfs(&node_ref.right, result);
                result.push(node_ref.val);
            }
        }    
        let mut result = Vec::new();
        dfs(&root, &mut result);
        result
    }
}
