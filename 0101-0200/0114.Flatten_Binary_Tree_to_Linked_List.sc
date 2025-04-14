//0ms


/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def flatten(root: TreeNode): Unit = {

    flatten(root, null)
  }
  
  private def flatten(root: TreeNode, prev: TreeNode): TreeNode = {
    
    root match {
      case null => prev
      case _ => {
        val prevRight = flatten(root.right, prev)
        val prevLeft = flatten(root.left, prevRight)
        
        root.right = prevLeft
        root.left = null
        root
      }
    }
  }
}
