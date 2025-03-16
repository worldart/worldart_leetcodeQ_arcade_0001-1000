//0ms


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
    public ListNode reverseLL(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode last = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right || head==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i=1;i<left;i++) prev = prev.next;
        ListNode start=prev.next, end=start;
        for(int i=left;i<right;i++) end=end.next;
        ListNode res = end.next;
        end.next = null;
        ListNode reversed = reverseLL(start);
        prev.next=reversed;
        start.next = res;
        return dummy.next;
    }
}
