//8ms



/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def postorderTraversal(root: TreeNode): List[Int] = 
    if (root == null) Nil else postorderTraversal(root.left) ++ postorderTraversal(root.right) :+ root.value
}




//3ms




/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def postorderTraversal(root: TreeNode): List[Int] = {
        def helper(tree: TreeNode): List[Int] = {
            if (tree == null) {
                return Nil
            }
            tree.value :: helper(tree.right) ::: helper(tree.left)
        }
        helper(root).reverse

    }
}
