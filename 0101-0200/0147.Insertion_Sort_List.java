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




//





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
        if(head==null || head.next==null)return head;
        ListNode prv = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            prv = slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prv.next=null;
        ListNode l1 = insertionSortList(head);
        ListNode l2 = insertionSortList(slow);
        return megreList(l1,l2);
    }
    private ListNode megreList(ListNode head1,ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                curr.next = head1;
                head1=head1.next;
            }
            else{
                curr.next = head2;
                head2=head2.next;
            }
            curr=curr.next;

        }
        if(head1!=null){
            curr.next = head1;
            
        }
        if(head2!=null){
            curr.next=head2;
        }
        return dummy.next;
    }
}































