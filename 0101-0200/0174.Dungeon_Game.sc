//10ms






object Solution {
    def calculateMinimumHP(dungeon: Array[Array[Int]]): Int = {
      val m = dungeon.length
      val n = dungeon(0).length
      val dp = Array.ofDim[Int](m, n)
      dp(m-1)(n-1) = math.max(1, 1 - dungeon(m-1)(n-1))
      for (i <- m-2 to 0 by -1) dp(i)(n-1) = math.max(1, dp(i+1)(n-1) - dungeon(i)(n-1))
      for (j <- n-2 to 0 by -1) dp(m-1)(j) = math.max(1, dp(m-1)(j+1) - dungeon(m-1)(j))
      for (i <- m-2 to 0 by -1; j <- n-2 to 0 by -1) dp(i)(j) = math.min(math.max(1, dp(i+1)(j) - dungeon(i)(j)), math.max(1, dp(i)(j+1) - dungeon(i)(j)))
      dp(0)(0)
    }







//7ms






object Solution:
    def calculateMinimumHP(dungeon: Array[Array[Int]]): Int = 
        val m = dungeon.length
        val n = dungeon(0).length
        var calculated = Array.ofDim[Int](m, n)

        def inner(idx: Int, idx1: Int, hp: Int): Int =
            if idx == 0 && idx1 == 0 then
                hp + dungeon(idx)(idx1)

            else
                val left = if idx1 > 0
                    then if calculated(idx)(idx1 - 1) == 0
                        then inner(idx, idx1 - 1, hp)
                        else calculated(idx)(idx1 - 1)
                    else -1

                val up = if idx > 0
                    then if calculated(idx - 1)(idx1) == 0
                        then inner(idx - 1, idx1, hp)
                        else calculated(idx - 1)(idx1)
                    else -1

                val leftCurr = if left > 0
                    then left + dungeon(idx)(idx1)
                    else -1

                val upCurr = if up > 0
                    then up + dungeon(idx)(idx1)
                    else -1

                val curr = if leftCurr > upCurr
                    then leftCurr
                    else upCurr

                calculated(idx)(idx1) = curr
                curr
        end inner

        var start = 1
        var end = 50_000_000
        var mid = start + (end - start) / 2
        var foundValue = -1
        var done = false

        while start <= end && !done do
            calculated = Array.ofDim[Int](m, n)
            mid = start + (end - start) / 2
            val res = inner(m - 1, n - 1, mid)

            if res < 1 then
                start = mid + 1

            else if res > 1 then
                end = mid - 1

            else
                done = true
                foundValue = mid

        if done then foundValue
        else start
    
end Solution
