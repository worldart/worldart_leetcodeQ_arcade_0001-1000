//17ms







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
impl Solution {
    pub fn insertion_sort_list(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut dummy = Box::new(ListNode::new(i32::MIN));
        let mut curr = head;
        
        while let Some(mut node) = curr {
            curr = node.next.take(); 
            let mut prev = &mut dummy;

            while prev.next.is_some() && prev.next.as_ref().unwrap().val < node.val {
                prev = prev.next.as_mut().unwrap();
            }
            
            node.next = prev.next.take();
            prev.next = Some(node);
        }
        
        return dummy.next
    }
}




//









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

impl Solution {
    pub fn insertion_sort_list(mut head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut ll = Vec::new();
        while let Some(mut node) = head.take() {
            head = node.next.take();
            ll.push(node.val);
        }

        ll.sort();
        head = None;
        for &val in ll.iter().rev() {
            head = Some(Box::new(ListNode { val, next: head }));
        }

        head
    }
}







//












