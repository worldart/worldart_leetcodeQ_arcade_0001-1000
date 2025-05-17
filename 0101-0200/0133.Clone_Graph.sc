//747ms



//BFS
def cloneGraph(graph: Node): Node =
  if (graph == null) null
  else {
    val result = new Node(graph.value)
    val copied = scala.collection.mutable.Map(result.value -> result)
    val queue = scala.collection.mutable.Queue(graph)
    while(queue.nonEmpty) {
      val node = queue.dequeue()
      copied(node.value).neighbors =
        node.neighbors.map { neighbor =>
          copied.getOrElseUpdate(neighbor.value, {
            queue.addOne(neighbor)
            new Node(neighbor.value)
          })
        }
    }
    result
  }




//778ms



//DFS
/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var neighbors: List[Node] = List()
 * }
 */

object Solution {
  import collection.mutable

  def cloneGraph(graph: Node): Node = {
    if (graph == null) return graph
    val visited = mutable.Map[Node, Node]()

    def dfs(node: Node): Node = {
      if (visited.contains(node)) visited(node)
      else {
        val cloned = new Node(node.value)
        visited.addOne(node, cloned)
        cloned.neighbors = node.neighbors.map(dfs)
        cloned
      }
    }
    
    dfs(graph)
  }
}




//689ms





/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var neighbors: List[Node] = List()
 * }
 */
import scala.collection.mutable
object Solution {
    def cloneGraph(graph: Node): Node = {
        val visited = mutable.Map.empty[Node, Node]
        def dfs(node: Node): Node = {
            val newNode = new Node(node.value)
            visited += (node -> newNode)
            newNode.neighbors = node.neighbors.map(n => if(visited.contains(n)) visited(n) else dfs(n))
            newNode
        }
        if(graph == null) return graph
        if(graph.neighbors.isEmpty) new Node(graph.value) else dfs(graph)
    }
}
