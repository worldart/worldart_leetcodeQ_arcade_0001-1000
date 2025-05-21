//716ms



object Solution {
    def copyRandomList(head: Node): Node = {
        @scala.annotation.tailrec
        def createClones(node: Node, clones: Map[Node, Node]): Map[Node, Node] = {
            if(node == null) clones
            else {
                val clone = new Node(node.value)
                createClones(node.next, clones + (node -> clone))
            }
        }
        val clones = createClones(head, Map.empty)
        @scala.annotation.tailrec
        def populateRandomPointers(newListNode: Node, originalListNode: Node): Unit = {
            if(newListNode == null) ()
            else {
                newListNode.random = clones.getOrElse(originalListNode.random, null)
                newListNode.next = clones.getOrElse(originalListNode.next, null)
                populateRandomPointers(newListNode.next, originalListNode.next)
            }
        }
        val newHead = clones.getOrElse(head, null)
        populateRandomPointers(newHead, head)
        newHead
    }
}



//677ms




/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var next: Node = null
 *   var random: Node = null
 * }
 */
// pointer
// current
// go to random
// 

object Solution {
    def copyRandomList(head: Node): Node = {
        // var dictionary = scala.collection.mutable.HashMap[Node, Node]()
        // def copyNode(node: Node): Node = {
        //     if node == null then null
        //     else if dictionary.contains(node) then dictionary.get(node).get
        //     else {
        //         var newNode = Node(node.value)
        //         dictionary.addOne((node,newNode)).map{(a,b) => 
        //             b.next = copyNode(a.next)
        //             b.random = copyNode(a.random)
        //         }
        //         newNode
        //     }
        // }

        if head == null then return null
        
        var current = Node(0)
        def interweaveNode(inputNode: Node): Unit = {
            current = Node(inputNode.value)
            current.random = null
            current.next = inputNode.next
            if (inputNode.next != null) {
                inputNode.next = current
                interweaveNode(current.next)
            } else {
                inputNode.next = current
                ()
                }
        }

        def addRandomConnectNodes(inputNode: Node): Unit = {
            if inputNode.next != null then
                if inputNode.random != null then inputNode.next.random = inputNode.random.next
                if inputNode.next.next !=null then addRandomConnectNodes(inputNode.next.next) else ()
            else ()
        }

        def unWeaveNode(inputNode: Node, savedHead: Node): Node = {
            if inputNode!=null && inputNode.next!=null && inputNode.next.next !=null then 
                current = inputNode.next
                inputNode.next = inputNode.next.next
                unWeaveNode(current,savedHead)
            else {
                    inputNode.next = null
                    savedHead
            }
        }

        interweaveNode(head)
        addRandomConnectNodes(head)
        unWeaveNode(head, head.next)
    }
}





//665ms





/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var next: Node = null
 *   var random: Node = null
 * }
 */

object Solution {
    def copyRandomList(head: Node): Node = {
        import scala.annotation.tailrec
        import scala.collection.mutable
        
        val oldToNewMapping: mutable.Map[Node, Node] = mutable.Map.empty

        @tailrec
        def initMapping(head: Node): Unit = if (head != null) {
            oldToNewMapping.put(head, new Node(head.value))
            initMapping(head.next)
        }

        def initLinks(head: Node): Unit = if (head != null) {
            val newHead = oldToNewMapping(head)
            if (head.next != null) newHead.next = oldToNewMapping(head.next)
            if (head.random != null) newHead.random = oldToNewMapping(head.random)
            initLinks(head.next)
        }

        initMapping(head)
        initLinks(head)
        if(head == null) null else oldToNewMapping(head)
    }
}
