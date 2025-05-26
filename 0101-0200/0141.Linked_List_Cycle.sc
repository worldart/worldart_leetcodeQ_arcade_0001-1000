//694ms



/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

object Solution {
    def hasCycle(head: ListNode): Boolean = {
      def go (slow: ListNode, fast: ListNode): Boolean = {
        (slow, fast) match {
          case (s, f) if f == null || f.next == null => false
          case (s, f) if s == f => true
          case (s, f) => go(s.next, f.next.next)
        }
      }
      if (head == null || head.next == null) false
      else go(head, head.next)
    }
}




//687ms




/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

object Solution {
    def hasCycle(head: ListNode): Boolean = {
        var slow = head
        var fast = head
        while(fast != null && fast.next != null){
            slow = slow.next
            fast = fast.next.next
            if(slow == fast) return true
        }
        return false
    }
}
