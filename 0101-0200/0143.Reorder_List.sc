//7ms



/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
  def reorderList(head: ListNode): Unit = {
    // If null just return
    if (head == null) return
    // Two point, one step once a time of slow, two steps once a time of fast, if the fast arrive the end of the list, the slow is the mid point of the list
    var low = head
    var fast = head.next
    while (fast != null && fast.next != null) {
      low = low.next
      fast = fast.next.next
    }
    // Reverse the backend list
    var backReversed = reverseList(low.next)
    var temp = head
    var prev = temp
    //split the prev list to the mid
    while (temp != null) {
      if (temp == low) temp.next = null
      temp = temp.next
    }

    // Just merge them!
    while (prev != null || backReversed != null) {
      val pTemp = prev.next
      val bTemp = if (backReversed != null) backReversed.next else null

      prev.next = backReversed
      if (backReversed != null) backReversed.next = pTemp
      prev = pTemp
      backReversed = bTemp
    }
  }

  def reverseList(head: ListNode): ListNode = {
    if (head == null) return null
    var result: ListNode = new ListNode(head.x)
    var curr = head.next
    while (curr != null) {
      result = new ListNode(curr.x, result)
      curr = curr.next
    }
    result
  }
}





//2ms





/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
  def reorderList(head: ListNode): Unit = {
    var h = head
    var size = 0
    var i = 0

    def go(curr: ListNode): Unit = {
      size += 1
      if (curr.next != null) go(curr.next)

      val entries = if (size % 2 == 0) size / 2 else size / 2 + 1

      if (i >= entries) {
        return
      }

      curr.next = null

      val n = h
      h = if (h != null && h.next != null) h.next else null

      if (n != null) {
        i += 1
        n.next = curr
        if (h != null && h.next != null) {
          curr.next = h
        } else {
          curr.next = null
        }

      }
    }

    if (head.next != null)
      go(head)
  }
}
