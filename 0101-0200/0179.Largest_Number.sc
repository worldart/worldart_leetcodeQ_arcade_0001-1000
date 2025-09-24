//30ms





object Solution {
  def largestNumber(nums: Array[Int]): String = {
    nums.map(_.toString).sortWith((x, y) => (x + y) > (y + x)).mkString.replaceFirst("^0+", "0")
  }
}



//28ms





object Solution {
    def largestNumber(nums: Array[Int]): String = {
        val result = nums.map(e => e.toString)
            .sortWith((e, e1) => e + e1 > e1 + e)
            .mkString("")

        if (result.head == '0') {
            result.head.toString
        } else {
            result
        }
    }
}
