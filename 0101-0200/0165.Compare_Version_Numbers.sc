//36ms






object Solution {
    def compareVersion(version1: String, version2: String): Int = {
        val arr1=version1.split("\\.").map(_.toInt)
        val arr2=version2.split("\\.").map(_.toInt)
        arr1.zipAll(arr2,0,0).collectFirst {
            case (v1,v2)   if   v1>v2   =>  1
            case (v1,v2)   if   v1<v2   => -1
        }.getOrElse(0)
    }
}





//38ms






object Solution {

      import scala.annotation.tailrec

      def compareVersion(version1 : String, version2 : String) : Int = {
         val v1 = version1.split('.').map(_.toInt)
         val v2 = version2.split('.').map(_.toInt)
         val i1 = v1.iterator ++ Iterator.continually(0)
         val i2 = v2.iterator ++ Iterator.continually(0)

         @tailrec
         def compare(remaining : Int) : Int = {
            if ( remaining > 0 ) {
               val res = i1.next() compareTo i2.next()
               if ( res == 0 ) compare(remaining - 1) else if ( res < 0 ) -1 else 1
            } else {
               0
            }
         }

         compare(v1.length max v2.length)
      }

}
