//0ms



/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
        def connect(first: ListNode, second: ListNode): ListNode = {
            if(first.next == null) ListNode(first.x, second)
            else ListNode(first.x, connect(first.next, second))
        }

        def reverse(base: ListNode, result: ListNode, count: Int): ListNode = {
            if(count == 0) connect(result, base)
            else reverse(base.next, ListNode(base.x, result), count-1)
        }
        
        def helper(root: ListNode, p: Int, result: ListNode): ListNode = {
            if(p >= left && p <= right) {
                result.next = reverse(root,null,right-left+1)
                result
            }
            else {
                result.next = new ListNode(root.x)
                helper(root.next, p + 1, result.next)
            }
        }
        val dummy = new ListNode(0)
        helper(head, 1, dummy)
        dummy.next
    }
}
