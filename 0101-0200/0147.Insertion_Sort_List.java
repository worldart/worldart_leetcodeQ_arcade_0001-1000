//20ms



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
public ListNode insertionSortList(ListNode head) {
  ListNode curr = head, next = null;
  // l is a fake head
  ListNode l = new ListNode(0);
  
  while (curr != null) {
    next = curr.next;
    
    ListNode p = l;
    while (p.next != null && p.next.val < curr.val)
      p = p.next;
    
    // insert curr between p and p.next
    curr.next = p.next;
    p.next = curr;
    curr = next;
  }
  
  return l.next;
}
}











