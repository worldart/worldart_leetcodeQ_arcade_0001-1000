//0ms


// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//   pub val: i32,
//   pub next: Option<Box<ListNode>>
// }
// 
// impl ListNode {
//   #[inline]
//   fn new(val: i32) -> Self {
//     ListNode {
//       next: None,
//       val
//     }
//   }
// }
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
    pub fn sorted_list_to_bst(head: Option<Box<ListNode>>) -> Option<Rc<RefCell<TreeNode>>> {
        let num = Self::list_to_vec(&head);
        Self::build_bst(&num)
    }
    fn build_bst(num: &[i32]) -> Option<Rc<RefCell<TreeNode>>>{
        if num.is_empty(){
            return None;
        }

        let mid = num.len()/2;
        let mut node = TreeNode::new(num[mid]);
        node.left = Self::build_bst(&num[..mid]);
        node.right = Self::build_bst(&num[mid+1..]);

        Some(Rc::new(RefCell::new(node)))
    }
    fn list_to_vec(list: &Option<Box<ListNode>>) -> Vec<i32>{
        let mut result = Vec::new();
        let mut current = list.as_ref();

        while let Some(node) = current{
            result.push(node.val);
            current = node.next.as_ref();
        }
        result
    }
}
