//47ms




object Solution {
    def reverseWords(s: String): String = {
        val lst = s.split(" ").toList.filter(_.nonEmpty)
        var lst2 = List[String]()
        lst.foreach(e => lst2 = e :: lst2 )
        lst2.mkString(" ")
    }
}





//30ms




object Solution {
  def reverseWords(s: String): String = {
    val arr = s.trim.replaceAll(" +", " ").toCharArray

    def reverse(_from: Int, _end: Int): Unit = {
      var from = _from
      var to = _end
      var tmp = ' '
      while (from < to) {
        tmp = arr(from)
        arr(from) = arr(to)
        arr(to) = tmp
        from += 1
        to -= 1
      }
    }

    var start = 0
    var end = 0
    while (end < arr.length) {
      if (arr(end) == ' ') then {
        reverse(start, end - 1)
        start = end + 1
      }
      else if (end == arr.length - 1) then {
        reverse(start, end)
        start = end + 1
      }
      else ()

      end += 1
    }

    reverse(0, arr.length - 1)
    arr.mkString
  }
}




//34ms





object Solution {
    def reverseWords(s: String): String = {
        val st = StringBuilder()
        val arr = s.split(" ")
        for(i <- arr.length -1 to 0 by -1)
            if(!arr(i).equals(" ") && !arr(i).equals(""))
                st.append(arr(i).trim+" ")
        st.toString.trim
    }
}
