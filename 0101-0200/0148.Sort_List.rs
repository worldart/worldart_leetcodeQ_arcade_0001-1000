//10ms



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
    pub fn sort_list(mut head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        if head.is_none() || head.as_ref().unwrap().next.is_none() {
            return head;
        }

        if head.as_ref().unwrap().next.as_ref().unwrap().next.is_none() {
            if head.as_ref().unwrap().val < head.as_ref().unwrap().next.as_ref().unwrap().val {
                return head;
            } else {
                let mut new_head = head.as_mut().unwrap().next.take();
                new_head.as_mut().unwrap().next = head;
                return new_head;
            }
        }

        let mut dummy = Box::new(ListNode::new(0));
        let mut current = &mut dummy;
        let mut fast: *const ListNode = &*head.as_deref().unwrap();
        let mut slow = &mut head;

        while !fast.is_null() && unsafe { (*fast).next.is_some() } {
            fast = unsafe {
                (*fast)
                    .next
                    .as_ref()
                    .map_or(std::ptr::null(), |node| node.as_ref() as *const _)
            };

            if unsafe { (*fast).next.is_none() } {
                break;
            }

            fast = unsafe {
                (*fast)
                    .next
                    .as_ref()
                    .map_or(std::ptr::null(), |node| node.as_ref() as *const _)
            };

            slow = &mut slow.as_mut().unwrap().next;
        }

        let mut head_1 = Self::sort_list(slow.take());
        let mut head_2 = Self::sort_list(head);

        while head_1.is_some() && head_2.is_some() {
            if head_1.as_ref().unwrap().val < head_2.as_ref().unwrap().val {
                current.next = head_1.take();
                current = current.next.as_mut().unwrap();
                head_1 = current.next.take();
            } else {
                current.next = head_2.take();
                current = current.next.as_mut().unwrap();
                head_2 = current.next.take();
            }
        }

        if head_1.is_some() {
            current.next = head_1.take();
        }

        if head_2.is_some() {
            current.next = head_2.take();
        }

        dummy.next
    }
}






//2ms







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
    pub fn sort_list(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut head = head;
        let mut node = head.as_ref();

        let mut values = vec![];

        while let Some(node_some) = node {
            values.push(node_some.val);
            node = node_some.next.as_ref();
        }

        values.sort_unstable();

        let mut node = head.as_mut();

        for value in values {
            let node_some = node.unwrap();
            node_some.val = value;
            node = node_some.next.as_mut();
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
    pub fn sort_list(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut node = head;
        let mut res = vec![] ;
        
        while let Some(curr) = node { 
            res.push(curr.val);
            node = curr.next ; 
        }
        res.sort(); 

        let mut head = Box::new(ListNode::new(0)) ;
        let mut p = &mut head;

        for i in 0..res.len() {
            p.next = Some(Box::new(ListNode::new(res[i]))); 
            p = p.next.as_mut().unwrap() ; 
        }
        head.next 
    }
}
