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




//1ms





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



//3ms





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
    ListNode dummy = new ListNode(0);
    ListNode prev = dummy; // the last and thus largest of the sorted list

    while (head != null) {       // the current inserting node
      ListNode next = head.next; // Cache the next inserting node.
      if (prev.val >= head.val)
        prev = dummy; // Move `prev` to the front.
      while (prev.next != null && prev.next.val < head.val)
        prev = prev.next;
      head.next = prev.next;
      prev.next = head;
      head = next; // Update the current inserting node.
    }

    return dummy.next;
  }
}





//1ms






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
    public ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                t.next = a;
                a = a.next;
            } else {
                t.next = b;
                b = b.next;
            }
            t = t.next;
        }

        if (a != null) t.next = a;
        else t.next = b;

        return dummy.next;
    }

    public ListNode mergesort(ListNode h) {
        if (h == null || h.next == null) return h;

        // Split list in two halves using slow-fast pointers
        ListNode slow = h, fast = h, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Break the list into two parts
        prev.next = null;

        ListNode left = mergesort(h);
        ListNode right = mergesort(slow);

        return merge(left, right); // ✔️ return the merged sorted list
    }

    // public ListNode sortList(ListNode head) {
    //     return mergesort(head); // ✔️ return the sorted list
    // }
    public ListNode insertionSortList(ListNode head) {
        return mergesort(head);
    }
}








