//0ms




impl Solution {
    pub fn remove_elements(head: Option<Box<ListNode>>, val: i32) -> Option<Box<ListNode>> {
        let mut head = head;
        let mut walker = &mut head;
        loop {
            match walker {
                None => break,
                Some(node) if node.val == val => {
                    *walker = node.next.take();
                },
                Some(node) => {
                    walker = &mut node.next;
                },
            }
        }
        head
    }
}





//3ms





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
    pub fn remove_elements(mut head: Option<Box<ListNode>>, val: i32) -> Option<Box<ListNode>> {
        let mut dummy = None;
        let mut tail = &mut dummy;

        while let Some(mut node) = head.take() {
            head = node.next.take();
            if node.val != val {
                *tail = Some(node);
                tail = &mut tail.as_mut().unwrap().next;
            }
        }
        dummy
    }
}





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
impl Solution {
    pub fn remove_elements(head: Option<Box<ListNode>>, val: i32) -> Option<Box<ListNode>> {
        std::iter::successors(head.as_deref(), |n| n.next.as_deref())
            .filter_map(|n| (n.val != val).then_some(n.val))
            .collect::<Vec<_>>()
            .into_iter()
            .rfold(None, |next, val| Some(Box::new(ListNode { val, next })))
    }
}































