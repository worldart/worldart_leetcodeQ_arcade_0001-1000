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
    def preorderTraversal(root: TreeNode): List[Int] = {
        Option(root) match {
            case Some(node) => List(node.value) ++ preorderTraversal(node.left) ++ preorderTraversal(node.right)
            case _ => List()
        }
    }





//5ms




/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def preorderTraversal(root: TreeNode): List[Int] = {
        if (root == null) {
            List.empty[Int]
        } else {
            (root.value +: preorderTraversal(root.left)) ++ preorderTraversal(root.right)
        }
    }
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
    def preorderTraversal(root: TreeNode): List[Int] = 
      if (root == null) Nil 
      else root.value :: preorderTraversal(root.left) ++ preorderTraversal(root.right)
}





//5ms






/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def fold[A](node: TreeNode, a: A)(f: (A, Int) => A)(g: (A, A, A) => A): A = node match {
        case null => a
        case _ => g(f(a, node.value), fold(node.left, a)(f)(g), fold(node.right, a)(f)(g))
    }
    
    def preorderTraversal(root: TreeNode): List[Int] =
        fold(root, List[Int]())((a, v) => v :: a)((v, l, r) => v ::: l ::: r)
}
