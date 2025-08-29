//61ms





/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

import scala.collection.mutable

class BSTIterator(_root: TreeNode) {
  private val stack = pushLefts(_root, mutable.Stack.empty)

  @annotation.tailrec
  private def pushLefts(node: TreeNode, acc: mutable.Stack[TreeNode]): mutable.Stack[TreeNode] = {
    if (node == null) acc
    else pushLefts(node.left, acc.push(node))
  }

  def next(): Int = {
    if (hasNext()) {
      val node = stack.pop()
      pushLefts(node.right, stack)
      node.value
    } else throw new NoSuchElementException
  }

  def hasNext(): Boolean = stack.nonEmpty
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * val obj = new BSTIterator(root)
 * val param_1 = obj.next()
 * val param_2 = obj.hasNext()
 */






//53ms






/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
class BSTIterator(_root: TreeNode) {
    var curr = _root

    def next(): Int = {
        var nextValue: Option[Int] = None
        while (nextValue == None) {
            if (curr.left == null) {
                nextValue = Some(curr.value)
                curr = curr.right
            } else {
                var prev = curr.left
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right
                }

                if (prev.right == null) {
                    prev.right = curr
                    curr = curr.left
                } else {
                    prev.right = null
                    nextValue = Some(curr.value)
                    curr = curr.right
                }
            }
        }
        nextValue.get
    }

    def hasNext(): Boolean = {
        curr != null
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * val obj = new BSTIterator(root)
 * val param_1 = obj.next()
 * val param_2 = obj.hasNext()
 */







//52ms







/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
class BSTIterator(_root: TreeNode) {
    var smallest: TreeNode = _root
    var stack = List[TreeNode]()

    while (smallest.left != null) {
        stack = smallest :: stack
        smallest = smallest.left
    }
    var iterator = new TreeNode(-1, null, smallest)

    def next(): Int = {
        if (iterator.right != null) {
            iterator = iterator.right
            while (iterator.left != null) {
                stack = iterator :: stack
                iterator = iterator.left
            }
        } else {
            val (up :: rest) = stack : @unchecked
            stack = rest
            iterator = up
        }
        iterator.value
    }

    def hasNext(): Boolean = !(iterator.right == null && stack.isEmpty)


}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * val obj = new BSTIterator(root)
 * val param_1 = obj.next()
 * val param_2 = obj.hasNext()
 */






//57ms






/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
class BSTIterator(_root: TreeNode) {
  private var stack = pushLefts(_root, Nil)

  @annotation.tailrec
  private def pushLefts(node: TreeNode, acc: List[TreeNode]): List[TreeNode] = {
    if (node == null) acc
    else pushLefts(node.left, node :: acc)
  }

  def next(): Int = stack match {
    case x :: xs =>
      stack = pushLefts(x.right, xs)
      x.value
    case Nil => throw new NoSuchElementException
  }

  def hasNext(): Boolean = stack.nonEmpty
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * val obj = new BSTIterator(root)
 * val param_1 = obj.next()
 * val param_2 = obj.hasNext()
 */
