//69ms




object Solution {
    import scala.collection.mutable.HashSet
    def findRepeatedDnaSequences(s: String): List[String] = {
        
        val hs = HashSet[String]()
        val ans = HashSet[String]()
        
        val n = s.size
        for(i <- 0 until n-9) {
            val str = s.substring(i, i+10)
            if(hs.contains(str))
                ans.add(str)
            
            hs.add(str)
        }
        ans.toList
    }
}





//61ms






object Solution {
    def findRepeatedDnaSequences(s: String): List[String] = {
        val strLength = s.length
        if (strLength <= 10) return List.empty

        val dnaSeqSet,repeatedSet: collection.mutable.HashSet[String] = collection.mutable.HashSet.empty
        for (rightPtr <- 9 until strLength) {
            val thisDnaSeq = s.slice(rightPtr - 9, rightPtr + 1)
            if (dnaSeqSet.contains(thisDnaSeq)) {
              repeatedSet.add(thisDnaSeq)
            }
            dnaSeqSet.add(thisDnaSeq)
        }
        repeatedSet.toList
    }
}






//261ms







object Solution {
  def findRepeatedDnaSequences: String => List[String] = _
    .sliding(10).toList.groupBy(identity)
    .filter{case (k,v) => v.size > 1}.keys.toList
}




