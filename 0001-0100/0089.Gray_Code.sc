//22ms 100RT 20250313



import scala.collection.mutable.ListBuffer
object Solution {
    def grayCode(n: Int): List[Int] = {
        val comboCt: Int = 1 << n
        val rtnVal: ListBuffer[Int] = ListBuffer[Int](0)
        for (num <- 1 until comboCt) {
            rtnVal.addOne(num ^ (num >> 1))
        }
        return rtnVal.toList
    }
}
