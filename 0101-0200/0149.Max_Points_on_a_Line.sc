//93ms




object Solution {


        def gcd(a:Int,b:Int):Int = {
            if(b==0){
                a
            }else{
                gcd(b,a%b)
            }
        }

        def maxPoints(points: Array[Array[Int]]): Int = {

        if(points.size == 1){
            1 // wrong ?
        }else{
        
            val counts = scala.collection.mutable.HashMap[(Int,Int,Int,Int), Int]()

            var i = 0
            val size = points.size
            
            while(i < size){
                var j = i + 1
                while(j < size){
                    val x0 = points(i)(0)
                    val y0 = points(i)(1)

                    val x1 = points(j)(0)
                    val y1 = points(j)(1)

                    val dx = x1 - x0
                    val dy = y1 - y0
                    
                    val (a,b) = if(dx == 0){
                        (Int.MaxValue, Int.MaxValue)
                    }else{
                        
                        val absDx = scala.math.abs(dx)
                        val absDy = scala.math.abs(dy)
                        val d = gcd(absDx,absDy)
                        
                        if( (dx >0 && dy >0) || (dx <0 && dy <0)){
                         (absDy/d , absDx/d)
                        }else{
                          (-absDy/d,absDx/d)  
                        }
                        
                    }

                    val (c,d) = if(dx==0){
                        (Int.MaxValue, x0)
                    }else{
                        val tc = dx*y0 - dy*x0
                        val td = dx
                        
                        val absTc = scala.math.abs(tc)
                        val absTd = scala.math.abs(td)
                        val d = gcd(absTc,absTd)
                        if( (tc >0 && td >0) || (tc <0 && td <0) ){
                            (absTc/d, absTd/d)
                        }else{
                            (-absTc/d, absTd/d)
                        }

                    }


                    val key = (a,b,c,d)


                    counts.update(key, counts.getOrElse(key,0) + 1)
                    j +=1 
                }
                i += 1
            }
        
            // println(counts.size)
            // println(counts)
            val maxValue = counts.maxBy(x=> x._2)._2

            ((1 + scala.math.sqrt(1+8*maxValue))/2).toInt
        }
    }
}






//569ms






object Solution {
  def maxPoints(points: Array[Array[Int]]): Int = {
    def sameLine(i1: Int, i2: Int, i3: Int): Boolean = {
      val Array(x1, y1) = points(i1)
      val Array(x2, y2) = points(i2)
      val Array(x3, y3) = points(i3)
      if (y1 == y2 && y1 == y3) {
        true
      } else if (x1 == x2 && x1 == x3) {
        true
      } else if (y1 == y2 || x1 == x2 || y1 == y3 || x1 == x3) {
        false
      } else if ((y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2)) {
        true
      } else {
        false
      }
    }

    if (points.size == 1) {
      1
    } else
      (for {
        i <- points.indices
        j <- points.indices if i != j
      } yield {
        points.indices.foldLeft(2) {
          case (n, idx) if i == idx || j == idx  => n
          case (n, idx) if (sameLine(i, j, idx)) => n + 1
          case (n, _)                            => n
        }
      }).max
  }
}
