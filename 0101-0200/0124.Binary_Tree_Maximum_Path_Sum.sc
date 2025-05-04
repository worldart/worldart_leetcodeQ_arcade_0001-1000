//1ms


/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def maxPathSum(root: TreeNode): Int = {

    var max: Int = Integer.MIN_VALUE

    def maxPath(root: TreeNode): Int = {
      if (root == null)
        return 0
      else {
        val left = Math.max(0, maxPath(root.left))
        val right = Math.max(0, maxPath(root.right))
        val currMax = root.value + left + right
        max = Math.max(max, currMax)

        root.value + Math.max(left, right)
      }
    }
    maxPath(root)
    max
  }

}
