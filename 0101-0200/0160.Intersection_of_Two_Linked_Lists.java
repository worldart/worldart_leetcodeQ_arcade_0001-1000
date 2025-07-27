//1ms




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ac = 0;
        int bc = 0;
        ListNode a = headA;
        ListNode b = headB;
        while(a != null){
            ac++;
            a = a.next;
        }
        while(b != null){
            bc++;
            b = b.next;
        }
        while(ac > bc){
            ac--;
            headA = headA.next;
        }
        while(bc > ac){
            bc--;
            headB = headB.next;
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}








//0ms







/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            new Solution().getIntersectionNode(new ListNode(1), new ListNode(2));
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int n1 = length(headA);
        int n2 = length(headB);

        if (n1 > n2)
            return getIntersectionNode(headB, headA);

        // n1 <= n2

        ListNode t1 = headA;
        ListNode t2 = headB;

        for (int i = 0; i < n2 - n1; i++) {
            t2 = t2.next;
        }

        while (t1 != null && t2 != null) {
            if (t1 == t2)
                return t1;

            t1 = t1.next;
            t2 = t2.next;
        }

        return null;
    }

    int length(ListNode head) {
        if (head == null)
            return 0;
        if (head.next == null)
            return 1;

        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }
}
