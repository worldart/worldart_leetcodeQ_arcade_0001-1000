//1698ms




object Solution {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    val n = gas.size

    @annotation.tailrec
    def loop(start: Int, current: Int, nVisited: Int, tank: Int): Int =
      if (start == n)
        -1
      else if (nVisited == n)
        start
      else {
        val tankAtNext = tank + gas(current) - cost(current)
        if (tankAtNext >= 0)
          loop(start, (current + 1) % n, nVisited + 1, tank = tankAtNext)
        else
          loop(start + 1, current = start + 1, nVisited = 0, tank = 0)
      }

    if (gas.sum < cost.sum)
      -1
    else {
      val firstPosDiff = 0 max gas.indices.indexWhere(i => gas(i) > cost(i))
      loop(
        start = firstPosDiff,
        current = firstPosDiff,
        nVisited = 0,
        tank = 0
      )
    }
  }
}




//4ms





object Solution {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {

    var totalGas = 0
    var currentGas = 0
    var startIndex = 0

    var i = 0
    while(i < gas.length) {
      totalGas += (gas(i) - cost(i))
      currentGas += (gas(i) - cost(i))

      if(currentGas < 0) {
        startIndex = i + 1
        currentGas = 0
      }
      i += 1
    }

    if(totalGas < 0) {
      -1
    } else {
      startIndex
    }

  }
}
