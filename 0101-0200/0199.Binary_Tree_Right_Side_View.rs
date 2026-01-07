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
use std::collections::VecDeque;
impl Solution {
    pub fn right_side_view(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        // Handle empty tree: return empty vector immediately
        if root.is_none() { return vec![]; }
        
        let mut result = vec![];           // Stores the rightmost values of each level
        let mut queue = VecDeque::new();   // Double-ended queue for Level-Order Traversal (BFS)
        queue.push_back(root.unwrap());    // Start BFS by pushing the root node
        
        // Loop until there are no more levels to process
        while !queue.is_empty() {
            let size = queue.len();        // Number of nodes at the CURRENT level
            
            // Process every node at this specific level
            for i in 0..size {
                let node = queue.pop_front().unwrap(); // Take node from the front of queue
                let node_ref = node.borrow();          // Borrow data inside RefCell safely
                
                // CRITICAL STEP: If i is the last index in this level (size - 1),
                // it is the rightmost node visible from the side.
                if i == size - 1 {
                    result.push(node_ref.val);
                }
                
                // Add left child to queue for the next level's processing
                if let Some(left) = &node_ref.left {
                    queue.push_back(left.clone());
                }
                
                // Add right child to queue for the next level's processing
                if let Some(right) = &node_ref.right {
                    queue.push_back(right.clone());
                }
            }
        }
        
        result // Return the final list of right-side visible values
    }
}







//0ms







// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,   // Left child wrapped in smart pointers
//   pub right: Option<Rc<RefCell<TreeNode>>>,  // Right child wrapped in smart pointers
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

use std::{cell::RefCell, rc::Rc};

impl Solution {
    pub fn right_side_view(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let mut ans = Vec::new(); // Initialize the result vector to store right-view values
        
        // Unwrap the root: if it's None, return the empty answer vector immediately
        let root = match root {
            Some(r) => r,
            None => return ans,
        };
        
        // Initialize the current level queue with the root node
        let mut q = vec![root];
        
        // Process the tree level by level until the queue is empty
        while !q.is_empty() {
            // Because we process left-to-right, the last element in the current 
            // queue (q) is the rightmost node of the current level.
            if let Some(last) = q.last() {
                ans.push(last.borrow().val); // Access value via borrow and push to result
            }
            
            // Prepare a temporary vector for the next level's nodes
            // Pre-allocating capacity (2x current) improves performance by reducing resizing
            let mut next_q = Vec::with_capacity(q.len() * 2);
            
            // Iterate through all nodes in the current level
            for node in q {
                let node_ref = node.borrow(); // Borrow node to access children
                
                // If a left child exists, add it to the next level queue
                if let Some(left) = &node_ref.left {
                    next_q.push(left.clone());
                }
                
                // If a right child exists, add it to the next level queue
                if let Some(right) = &node_ref.right {
                    next_q.push(right.clone());
                }
            }
            
            // Move to the next level by replacing the current queue with next_q
            q = next_q;
        }
        
        ans // Return the final collected right-side values
    }
}
