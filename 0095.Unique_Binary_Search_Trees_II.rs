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
    pub fn generate_trees(n: i32) -> Vec<Option<Rc<RefCell<TreeNode>>>> {
        if n == 0 {
            return Vec::new();
        }
        Self::generate(1, n)
    }

    fn generate(start: i32, end: i32) -> Vec<Option<Rc<RefCell<TreeNode>>>> {
        if start > end {
            return vec![None];
        }

        let mut all_trees = Vec::new();
        for i in start..=end {
            let left_trees = Self::generate(start, i - 1);
            let right_trees = Self::generate(i + 1, end);

            for l in &left_trees {
                for r in &right_trees {
                    let current_tree = Some(Rc::new(RefCell::new(TreeNode::new(i))));
                    current_tree.as_ref().unwrap().borrow_mut().left = l.clone();
                    current_tree.as_ref().unwrap().borrow_mut().right = r.clone();
                    all_trees.push(current_tree);
                }
            }
        }
        all_trees
    }
}
