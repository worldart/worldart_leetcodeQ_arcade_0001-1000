//6ms



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

  pub fn reorder_list(mut head: &mut Option<Box<ListNode>>) {
    let (mut f, mut s, mut c) = (head.clone(), head.clone(), 0);
    while f.is_some() && f.as_mut().unwrap().next.is_some()  {
      f = f.unwrap().next.unwrap().next;
      s = s.unwrap().next; c += 1
    }
    if c < 1 { return }
    let mut prev = None;
    while let Some(mut s_box) = s {
      let next = s_box.next;
      s_box.next = prev;
      prev = Some(s_box);
      s = next;
    }
    let mut s = head;
    while let Some(mut s_box) = s.take() {
      let next = s_box.next;
      if prev.is_none() && !f.is_some() || next.is_none() && f.is_some()  { 
        s_box.next = None;
        return;
      }
      s_box.next = prev;
      s = &mut s.insert(s_box).next;
      prev = next;
    }
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

use std::collections::VecDeque;

impl Solution {
    pub fn reorder_list(head: &mut Option<Box<ListNode>>) {
        let mut dq: VecDeque<Box<ListNode>> = VecDeque::new();
        let mut node = head.take();

        while let Some(mut n) = node {
            node = n.next.take();
            dq.push_back(n);
        }

        let mut new = ListNode::new(0);
        let (mut ptr, mut front) = (&mut new, true);

        while !dq.is_empty() {
            ptr.next = match front {
                true => dq.pop_front(),
                false => dq.pop_back()
            };
            front = !front;
            ptr = ptr.next.as_mut().unwrap();
        }

        *head = new.next;
    }
}
