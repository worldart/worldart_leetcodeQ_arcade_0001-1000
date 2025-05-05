//31ms


object Solution {
  def isPalindrome(s: String): Boolean = {
    val filtered = s.filter(_.isLetterOrDigit)
    filtered.reverse equalsIgnoreCase filtered
  }
}




//26ms


object Solution {
    def isPalindrome(s: String): Boolean = {
       val str = s.toLowerCase.toCharArray

       var start = 0
       var end = str.length - 1

       while (start < end) {
          if (!str(start).isLetterOrDigit) start += 1
          else if (!str(end).isLetterOrDigit) end -= 1
          else if (str(start) != str(end)) return false
          else {
             start += 1
             end -= 1
          }
     }

       true

}}




//4ms


object Solution {
  def isPalindrome(s: String): Boolean = {
    def isLowerAlphaNumeric(c: Char): Boolean = c >= 97 && c <= 122 || c >= 48 && c <= 57 || c >= 65 && c <= 90
    def toLower(c: Char): Char = if (c >= 65 && c <= 90) (c + 32).toChar else c

    val l = s.length
    var i = 0
    var j = l - 1
    var lc: Char = 0
    var rc: Char = 0
    var isPal: Boolean = true
    while (isPal && i < l && j >= 0) {
      lc = s.charAt(i)
      rc = s.charAt(j)
      if (isLowerAlphaNumeric(lc) && isLowerAlphaNumeric(rc)) {
        isPal = isPal && toLower(lc) == toLower(rc)
        i += 1
        j -= 1
      } else {
        if (!isLowerAlphaNumeric(lc)) i+= 1
        if (!isLowerAlphaNumeric(rc)) j-= 1
      }
    }
    isPal
  }
}
