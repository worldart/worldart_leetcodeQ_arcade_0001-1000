//22ms






/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def rightSideView(root: TreeNode): List[Int] = rightSideView(Option(root).toSeq)

  @scala.annotation.tailrec
  private def rightSideView(nodes: Seq[TreeNode], view: List[Int] = List()): List[Int] = {
    if (nodes.isEmpty) {
      view
    } else {
      rightSideView(nodes.flatMap(node => Seq(Option(node.left), Option(node.right)).flatten), view :+ nodes.last.value)
    }
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
    def rightSideView(root: TreeNode): List[Int] = {
        val res = scala.collection.mutable.ListBuffer.empty[Int]

        def dfs(node: TreeNode, h: Int): Unit = 
            if node != null then
                if h >= res.size then
                    res += node.value
                
                dfs(node.right, h + 1)
                dfs(node.left, h + 1)
        
        dfs(root, 0)
        res.result
    }
}
