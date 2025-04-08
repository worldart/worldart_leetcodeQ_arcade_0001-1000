//23ms


/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
import scala.collection.mutable.ListBuffer
object Solution {
    def levelOrderBottom(root: TreeNode): List[List[Int]] = {
        val res = new ListBuffer[List[Int]]
        val queue = scala.collection.mutable.Queue[TreeNode]()
        if (root == null) return res.toList
        queue.enqueue(root);
        while (queue.nonEmpty) {
            val n = queue.size;
            val arr = new ListBuffer[Int]
            (0 until n).foreach(_ => {
                val node = queue.dequeue()
                arr.append(node.value)
                if (node.left != null)
                queue.enqueue(node.left)
                if (node.right != null)
                queue.enqueue(node.right)

            })
            res.append(arr.toList)
        }
        res.toList.reverse
    }
}
