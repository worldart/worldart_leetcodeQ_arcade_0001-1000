//3ms





object Solution {
    def rangeBitwiseAnd(left: Int, right: Int): Int = {
        var l = left
        var r = right

        while(r > l) {
            r = r&(r-1)
        } 

        return r
    }
}





//1211ms






object Solution {
    def rangeBitwiseAnd(left: Int, right: Int): Int = {
        if (left == right) right 
        else {
            @scala.annotation.tailrec
            def rangeBitwiseAndRec(left: Int, right: Int, sum: Int): Int = {
                if (left >= right || sum == 0) sum
                else rangeBitwiseAndRec(left + 1, right, sum & left)
            }
            rangeBitwiseAndRec(left + 1, right, left & right)
        }
    }
}





//3ms





object Solution {
def rangeBitwiseAnd(left: Int, right: Int): Int = {
  val commonPrefix = Integer.highestOneBit(left ^ right)
  left & (-1 << Integer.numberOfTrailingZeros(commonPrefix))
}
}
