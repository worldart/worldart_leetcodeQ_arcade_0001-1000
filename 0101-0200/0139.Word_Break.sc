//11ms



object Solution {    
    def wordBreak(s: String, dict: List[String]): Boolean = {  
        val cache = collection.mutable.Map.empty[Int, Boolean]
  
        def solve(s: String): Boolean = 
            s.isEmpty || cache.getOrElseUpdate(s.length, dict.exists(w => s.startsWith(w) && solve(s.substring(w.length))))
        
        solve(s)
    }
}




//4ms




object Solution {
    def wordBreak(s: String, wordDict: List[String]): Boolean = {
        val dp = Array.fill[Boolean](s.length + 1)(false)
        dp(s.length) = true

        var index = s.length - 1
        while index >= 0 do {
            var dictWordIndex = 0
            wordDict.find{word =>
                (index + word.length) <= s.length &&
                word == s.substring(index, index + word.length) &&
                dp(index + word.length)
            } match {
                case None => ()
                case Some(word) => dp(index) = dp(index + word.length)
            }
            index -= 1
        }

        //println(dp.toList)

        dp(0)
    }
}




//4ms




object Solution {
    def wordBreak(s: String, wordDict: List[String]): Boolean = {
        val dp = Array.fill[Boolean](s.length + 1)(false)
        dp(s.length) = true

        var index = s.length - 1
        while index >= 0 do {
            var dictWordIndex = 0
            wordDict.find{word =>
                (index + word.length) <= s.length &&
                word == s.substring(index, index + word.length) &&
                dp(index + word.length)
            } match {
                case None => ()
                case Some(word) => dp(index) = true
            }
            index -= 1
        }

        //println(dp.toList)

        dp(0)
    }
}





//6ms





import scala.util.boundary, boundary.break

object Solution {
    def wordBreak(s: String, wordDict: List[String]): Boolean = {
        val memo = Array.fill(s.length + 1)(-1)
        def dp(i: Int): Boolean = boundary {
            if (i >= s.length) return true
            if (memo(i) > -1) return memo(i) == 1

            for (word <- wordDict) {
                if (i + word.length <= s.length && s.substring(i, i + word.length) == word) {
                    if (dp(i + word.length)) {
                        memo(i) = 1
                        break(true)
                    }
                }
            }

            memo(i) = 0
            false
        }

        dp(0)
    }
}
