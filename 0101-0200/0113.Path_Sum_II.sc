//7ms

/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    var tSum = 0
    def pathSum(root: TreeNode, targetSum: Int): List[List[Int]] = {
        tSum = targetSum
        go(root, 0, Nil).map(_.reverse)
    }

    def go(root: TreeNode, cSum: Int, pref: List[Int]): List[List[Int]] = root match {
        case null => Nil
        case _ =>
            val nSum = root.value + cSum
            if root.left == null && root.right == null then
                if nSum == tSum then List(root.value :: pref) else Nil
            else 
                go(root.left, nSum, root.value :: pref) 
                ++ go(root.right, nSum, root.value :: pref)
    }
}
