//26ms





object Solution {
    def titleToNumber(columnTitle: String): Int = {
        // Fold left through the columnTitle string, accumulating the result
        columnTitle.foldLeft(0) { (result, char) =>
            // Multiply the current result by 26 and add the current character's value
            result * 26 + (char - 'A' + 1)
        }
    }
}






//26ms






object Solution {
    def titleToNumber(columnTitle: String): Int = {
        var result = 0;
        for (ch <- columnTitle) {
            result = result * 26 + charToNumber(ch)
        }
        result
        
    }

    private def charToNumber(c: Char): Int = {
    c - 'A' + 1
  }
}






//26ms







object Solution {
  def getInt(c: Char): Int =
    c.toInt - 64

  def titleToNumber(columnTitle: String, multiplier: Int = 0): Int = {
    if (columnTitle.isEmpty) 0
    else if (multiplier == 0) getInt(columnTitle.last) + titleToNumber(columnTitle.take(columnTitle.length - 1), multiplier + 1)
    else getInt(columnTitle.last) * math.pow(26, multiplier).toInt + titleToNumber(columnTitle.take(columnTitle.length - 1), multiplier + 1)
  }
}
