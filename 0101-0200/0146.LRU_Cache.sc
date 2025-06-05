//195ms




import scala.collection.mutable

class LRUCache(_capacity: Int) {
  var head: Node = Node(-1, -1)
  var tail: Node = Node(-1, -1)
  head.next = tail
  tail.pre = head
  val map = mutable.HashMap.empty[Int, Node]

  def get(key: Int): Int = {
    map.get(key).fold(-1) { node =>
      if (head.next != node) {
        remove(node)
        add(node)
      }
      node.value
    }
  }

  def put(key: Int, value: Int): Unit = {
    map
      .get(key)
      .fold {
        if (map.size == _capacity) {
          map.remove(tail.pre.key)
          remove(tail.pre)
        }
        val node = Node(key, value)
        map.put(key, node)
        add(node)
        ()
      } { node =>
        remove(node)
        node.value = value
        add(node)
      }
  }

  def add(node: Node): Unit = {
    val head_next = head.next
    head.next = node
    node.pre = head
    node.next = head_next
    head_next.pre = node
  }

  def remove(node: Node): Unit = {
    val pre_node  = node.pre
    val next_node = node.next
    pre_node.next = next_node
    next_node.pre = pre_node
  }
}

case class Node(key: Int, var value: Int, var pre: Node = null, var next: Node = null)

/**
 * Your LRUCache object will be instantiated and called as such:
 * val obj = new LRUCache(capacity)
 * val param_1 = obj.get(key)
 * obj.put(key,value)
 */





  //149ms





  import scala.collection.mutable

class DoubleLinkedList {
    var head: ListNode = _

    def tail: ListNode = head.next

    def appendToHead(key: Int, value: Int): Unit = appendToHead(new ListNode(key, value))

    def appendToHead(newHead: ListNode): Unit = {
      if (head == null) {
        newHead.next = newHead
        newHead.prev = newHead
      } else {
        val tail = head.next
        tail.prev = newHead
        newHead.next = tail
        newHead.prev = head
        head.next = newHead
      }
      head = newHead
    }

    def remove(node: ListNode): Unit = {
      node.prev.next = node.next
      node.next.prev = node.prev
      if (node == head) head = node.prev
    }

    override def toString: String = {
      def loop(head: ListNode, node: ListNode): List[String] =
        if (node.prev == head) List(node.key.toString) else node.key.toString :: loop(head, node.prev)

      loop(head, head).mkString(", ")
    }
}
class ListNode(val key: Int, val value: Int, var prev: ListNode = null, var next: ListNode = null)

class LRUCache(_capacity: Int) {
    private val cache: mutable.Map[Int, ListNode] = new mutable.HashMap[Int, ListNode]
    var lruList: DoubleLinkedList = new DoubleLinkedList()

    def get(key: Int): Int = cache.get(key) match {
        case Some(v) =>
          lruList.remove(v)
          lruList.appendToHead(v)
          v.value
        case None => -1
    }
      

    def put(key: Int, value: Int): Unit = {
      cache.remove(key).foreach(lruList.remove)

      if (cache.size >= _capacity) {
        val tail = lruList.tail
        cache.remove(tail.key)
        lruList.remove(tail)
      }

      lruList.appendToHead(key, value)
      cache.put(key, lruList.head)
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * val obj = new LRUCache(capacity)
 * val param_1 = obj.get(key)
 * obj.put(key,value)
 */
