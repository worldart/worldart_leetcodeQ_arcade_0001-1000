//5305ms




/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
import scala.collection.mutable.ListBuffer
object Solution {
    def sortList(head: ListNode): ListNode = {

        
        var l =ListBuffer[Int]()
        var ptr=head
        while(ptr!=null)
        {
            l += ptr.x
            ptr= ptr.next
        }
        l = l.sorted
        if (l.length > 0) {
        var nodes= ListNode(l(0))
        var c =nodes
        var i =1
        while(i<l.length){
            c.next =ListNode(l(i))
            c =c.next
            i+=1
        }
        return nodes
        }
        return null
       
    }
}





// 9ms




/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */



object Solution {
    val dummyHead = new ListNode(0)


    def split(slow: ListNode, fast: ListNode): ListNode = {
        if (fast == null || fast.next == null) {
            val right = slow.next
            slow.next = null
            right
        } else {
            split(slow.next, fast.next.next)
        }
    }


    def merge(_left: ListNode, _right: ListNode): ListNode = {
        var left = _left
        var right = _right
        val result = dummyHead
        var head = result

        while (left != null && right != null) {
            if (left.x < right.x) {
                head.next = left
                left = left.next
            } else {
                head.next = right
                right = right.next
            }
            head = head.next
        }

        if (left != null) {
            head.next = left
        } else {
            head.next = right
        }

        result.next
    }

 
    def domergerec(left: ListNode, right: ListNode, head: ListNode = dummyHead, result: ListNode = dummyHead): ListNode = {
        if (left != null && right != null) {
            if (left.x < right.x) {
                head.next = left
                domergerec(left.next, right, head.next, result)
            } else {
                head.next = right
                domergerec(left, right.next, head.next, result)
            }
        } else if (left != null) {
            head.next = left
            domergerec(left.next, right, head.next, result)
        } else if (right != null) {
            head.next = right
            domergerec(left, right.next, head.next, result)
        } else {
            result.next
        }
    }

    def sortList(head: ListNode): ListNode = {
        if (head == null) {
            null
        } else if (head.next == null) {
            head
        } else {
            val rightHead = split(head, head.next)
            val left = sortList(head)
            val right = sortList(rightHead)

            merge(left, right)
        }
    }
}





//9ms









