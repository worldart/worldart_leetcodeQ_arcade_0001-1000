//26ma





object Solution {
  private val ops = Map[String, (Int, Int) => Int]("+" -> (_ + _), "-" -> (_ - _), "*" -> (_ * _), "/" -> (_ / _))
  
  def evalRPN(tokens: Array[String]): Int = 
    tokens.foldLeft(List.empty[Int]) { (stack, token) =>
      ops.get(token).fold(token.toInt :: stack)(_(stack.tail.head, stack.head) :: stack.tail.tail)
    }.head
}





//14ms





object Solution {

    @scala.annotation.tailrec
    def evaluate(tokens: Array[String], index: Int = 0, stack: Seq[Int] = Seq.empty): Int = {
        if (index >= tokens.length) {
            stack.head
        } else {
            tokens(index) match {
                case "+" =>
                    val rightOperand = stack.head
                    val leftOperand = stack.tail.head
                    val result = leftOperand + rightOperand
                    evaluate(tokens, index + 1, result +: stack.tail.tail)
                case "-" =>
                    val rightOperand = stack.head
                    val leftOperand = stack.tail.head
                    val result = leftOperand - rightOperand
                    evaluate(tokens, index + 1, result +: stack.tail.tail)
                case "*" =>
                    val rightOperand = stack.head
                    val leftOperand = stack.tail.head
                    val result = leftOperand * rightOperand
                    evaluate(tokens, index + 1, result +: stack.tail.tail)
                case "/" =>
                    val rightOperand = stack.head
                    val leftOperand = stack.tail.head
                    val result = leftOperand / rightOperand
                    evaluate(tokens, index + 1, result +: stack.tail.tail)
                case number =>
                    evaluate(tokens, index + 1, Integer.parseInt(number) +: stack)
            }
        }
    }

    def evalRPN(tokens: Array[String]): Int = {
        evaluate(tokens)
    }
}
