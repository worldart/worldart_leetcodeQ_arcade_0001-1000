//716ms






/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

object Solution {
    def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {

        @scala.annotation.tailrec
        def loop(pointerA: ListNode, pointerB: ListNode): ListNode = 
            if (pointerA == pointerB) pointerA
            else if (pointerA == null) loop(headB, pointerB.next)
            else if (pointerB == null) loop(pointerA.next, headA)
            else loop(pointerA.next, pointerB.next)

        loop(headA, headB)
    }
}






//716ms






/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

object Solution {


  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    if (headA == headB) headA
    else {
      var aLen, bLen = 1
      var i = 0
      var tmpA = headA
      var tmpB = headB
      while (tmpA.next != null) {
        tmpA = tmpA.next
        aLen = aLen + 1
      }
      while (tmpB.next != null) {
        tmpB = tmpB.next
        bLen = bLen + 1
      }
      // if they don't match then there is no intersection
      if (tmpA == tmpB) {
        if (aLen > bLen) {
          tmpA = headA
          while (i < aLen - bLen) {
            tmpA = tmpA.next
            i = i + 1
          }
          tmpB = headB
        } else if (bLen > aLen) {
          tmpB = headB
          while (i < bLen - aLen) {
            tmpB = tmpB.next
            i = i + 1
          }
          tmpA = headA
        } else {
          tmpB = headB
          tmpA = headA
        }
        while (tmpA != tmpB && (tmpA != null && tmpB != null)) {
          tmpB = tmpB.next
          tmpA = tmpA.next
        }
        tmpA // it does not metter which node to return they are either both null or equal
      }
      else null
    }
  }
}
