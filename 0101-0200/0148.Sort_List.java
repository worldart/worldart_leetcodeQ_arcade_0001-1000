//9ms


class Solution {
//takesoumen collection 
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // Find the middle of the list
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Split the list
        ListNode mid = slow.next;
        slow.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}




//2ms





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
    private void quickSort(ListNode head, ListNode end) {
        if (head.next == null || head.next.next == null || head.next == end || head.next.next == end) {
            return;
        }

        ListNode mid = head.next;
        ListNode prev = mid;
        boolean isSorted = true;
        while (prev.next != end) {
            isSorted = isSorted && (prev.val <= prev.next.val);
            if (prev.next.val < mid.val) {
                ListNode node = prev.next;
                prev.next = prev.next.next;
                node.next = head.next;
                head.next = node;
            } else {
                prev = prev.next;
            }
        }

        if (isSorted) {
            return;
        }
        quickSort(head, mid);
        quickSort(mid, end);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(0, head);
        quickSort(node, null);
        return node.next;
    }
}
