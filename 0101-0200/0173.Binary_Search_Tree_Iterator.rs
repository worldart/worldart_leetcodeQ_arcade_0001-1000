//3ms






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
    cell::RefCell,
    rc::Rc,
};
type TNode = Option<Rc<RefCell<TreeNode>>>;

struct BSTIterator {
    stack: Vec<i32>,
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl BSTIterator {
    fn new(root: Option<Rc<RefCell<TreeNode>>>) -> Self {
        fn push(root: &TNode, stack: &mut Vec<i32>) {
            match root {
                Some(root) => {
                    let node = root.as_ref().borrow();
                    push(&node.right, stack);
                    stack.push(node.val);
                    push(&node.left, stack);
                }
                None => {}
            }
        }
        let mut stack = Vec::new();
        push(&root, &mut stack);
        Self { stack }
    }

    fn next(&mut self) -> i32 {
        self.stack.pop().unwrap()
    }

    fn has_next(&self) -> bool {
        !self.stack.is_empty()
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * let obj = BSTIterator::new(root);
 * let ret_1: i32 = obj.next();
 * let ret_2: bool = obj.has_next();
 */






//7ms






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
struct BSTIterator {
    traversal: Vec<i32>,
}

use std::rc::Rc;
use std::cell::RefCell;
/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl BSTIterator {

    fn new(root: Option<Rc<RefCell<TreeNode>>>) -> Self {
        let mut traversal = Vec::new();
        build_inorder_traversal(root, &mut traversal);
        BSTIterator { traversal }
    }
    
    fn next(&mut self) -> i32 {
        self.traversal.pop().unwrap()
    }
    
    fn has_next(&self) -> bool {
        return !self.traversal.is_empty();
    }

}

pub fn build_inorder_traversal(current: Option<Rc<RefCell<TreeNode>>>, traversal: &mut Vec<i32>) {
    if let Some(node) = current {
        let node_ref = node.borrow();
        //invert for the stack order
        build_inorder_traversal(node_ref.right.clone(), traversal);
        traversal.push(node_ref.val);
        build_inorder_traversal(node_ref.left.clone(), traversal);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * let obj = BSTIterator::new(root);
 * let ret_1: i32 = obj.next();
 * let ret_2: bool = obj.has_next();
 */




//3ms





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
struct BSTIterator {
        values: Vec<i32>,
        counter: usize,
        end: usize,
    }

/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */

    impl BSTIterator {
        pub fn new(root: Option<Rc<RefCell<TreeNode>>>) -> Self {
            let mut stack: Vec<Rc<RefCell<TreeNode>>> = Vec::new();
            let mut acc: Vec<i32> = Vec::new();
            let mut curr = root;

            while curr.is_some() || !stack.is_empty() {
                while let Some(ref node) = curr {
                    stack.push(node.clone());
                    curr = node.clone().borrow().left.clone();
                }

                let node = stack.pop();
                acc.push(node.as_ref().unwrap().borrow().val);
                curr = node.unwrap().borrow().right.clone();
            }
            let l = acc.len();

            Self {
                values: acc,
                counter: 0,
                end: l,
            }
        }

        fn next(&mut self) -> i32 {
            self.counter += 1;
            self.values[self.counter as usize - 1]
        }

        fn has_next(&self) -> bool {
            self.counter < self.end
        }
    }
/**
 * Your BSTIterator object will be instantiated and called as such:
 * let obj = BSTIterator::new(root);
 * let ret_1: i32 = obj.next();
 * let ret_2: bool = obj.has_next();
 */
