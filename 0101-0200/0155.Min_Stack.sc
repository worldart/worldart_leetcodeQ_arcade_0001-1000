//48ms




import scala.collection.mutable.ArrayBuffer

class MinStack() {

  val stack = ArrayBuffer[(Int, Int)]()

  def push(`val`: Int): Unit = {
    if (stack.isEmpty) stack.addOne((`val`, `val`))
    else stack.addOne((`val`, Math.min(`val`, stack.last._2)))
  }

  def pop(): Unit = {
    if (stack.nonEmpty) stack.remove(stack.size - 1)
  }

  def top(): Int = {
    stack(stack.size - 1)._1
  }

  def getMin(): Int = {
    stack(stack.size - 1)._2
  }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * val obj = new MinStack()
 * obj.push(`val`)
 * obj.pop()
 * val param_3 = obj.top()
 * val param_4 = obj.getMin()
 */





 //38ms





 class MinStack() {
    var head :Node = null 
    class Node(var value : Int , var next : Node , var min :Int)

    def push(`val`: Int): Unit = {
        
        if(head == null){
            head = new Node(`val`,null,`val`)
        }else{
            var node :Node = new Node(`val`,null,`val`)
            node.next = head 
            node.min = math.min(head.min,node.min)
            head = node
        }
    }

    def pop(): Unit = {
        if(head!=null)head = head.next
    }

    def top(): Int = {
        if(head!=null)return head.value
        -1
    }

    def getMin(): Int = {
        if(head!=null)return head.min
        -1
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * val obj = new MinStack()
 * obj.push(`val`)
 * obj.pop()
 * val param_3 = obj.top()
 * val param_4 = obj.getMin()
 */
