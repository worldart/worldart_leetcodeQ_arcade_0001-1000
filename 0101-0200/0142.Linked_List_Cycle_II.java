//0ms



/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}




//0ms




public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return startingPoint(head,fast,slow);
            }
        }
         return null;
        
    }
    public ListNode startingPoint(ListNode head, ListNode fast, ListNode slow){
        slow=head;
            while(fast!=slow){
                fast=fast.next;
                slow=slow.next;

            }
            return slow;
    }
}





//0ms






/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int len = length(head);
        if(len==-1)
        {
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        while(len>0)
        {
            f=f.next;
            len--;
        }
        while(f!=s)
        {
            f=f.next;
            s=s.next;
        }
        return s;
    }
    int length(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;        
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
            {
                int length = 0;
                ListNode temp = slow;
                do
                {
                    length++;
                    temp = temp.next;
                }while(temp!=slow);
                return length;
            }
        }
        return -1;
    }
}
