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





/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
  def sortList(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    var slow = head
    var fast = head.next
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    val mid = slow.next
    slow.next = null
    val left = sortList(head)
    val right = sortList(mid)
    merge(left, right)
  }

  private def merge(l1: ListNode, l2: ListNode): ListNode = {
    val dummy = new ListNode(0)
    var tail = dummy
    var node1: ListNode = l1
    var node2: ListNode = l2
    while (node1 != null && node2 != null) {
      if (node1.x < node2.x) {
        tail.next = node1
        node1 = node1.next
      } else {
        tail.next = node2
        node2 = node2.next
      }
      tail = tail.next
    }
    tail.next =
      if (node1 != null) node1
      else node2
    dummy.next
  }
}






//15ms






/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */


object Solution {
  import scala.annotation.tailrec
  @tailrec
  def mergeList(l1: ListNode, l2: ListNode, last: ListNode): Unit = {
    if (l1 == null && l2 == null) {
      last.next = null
    } else if (l1 == null || (l2 != null && l1.x > l2.x)) {
      last.next = l2
      mergeList(l1, l2.next, l2)
    } else {
      last.next = l1
      mergeList(l1.next, l2, l1)
    }
  }


  def listMid(fast: ListNode, slow: ListNode): ListNode = {
    if (fast.next == null || fast.next.next == null) {
      slow
    } else {
      listMid(fast.next.next, slow.next)
    }
  }

  def sortList(head: ListNode): ListNode = {
    if (head == null || head.next == null) {
      head
    } else {
      val mid = listMid(head, head)
      // detatch
      val tmp = mid.next
      mid.next = null

      val left = sortList(head)
      val right = sortList(tmp)

      val root = ListNode()
      mergeList(left, right, root)
      root.next
    }
  }
}
