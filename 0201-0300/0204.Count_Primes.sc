//92ms






object Solution {
  def countPrimes(n: Int): Int = {
    if (n <= 2) return 0
    
    val isPrime = Array.fill(n)(true)
    isPrime(0) = false
    isPrime(1) = false
    
    var count = 0
    var p = 2
    while (p < n) {
      if (isPrime(p)) {
        count += 1
        // Mark multiples starting from p * p to avoid redundant checks
        // Use Long for j to prevent integer overflow
        var j = p.toLong * p
        while (j < n) {
          isPrime(j.toInt) = false
          j += p
        }
      }
      p += 1
    }
    count
  }
}





//145ms






object Solution {
    def countPrimes(n: Int): Int = {
    val prime = Array.fill(n + 1)(true)
    var count = 0
    var p = 2
    while (p * p <= n) {
      if (prime(p)) {
        var i = p * p
        while (i <= n) {
          prime(i) = false
          i += p
        }
      }
      p += 1
    }
    for (p <- 2 until n) {
      if (prime(p))
        count += 1
    }
    count
  }
}





//172ms









object Solution {
    def countPrimes(n: Int): Int = {
        var result = 0
        val seen = Array.fill(n)(false)
        var num = 2
        for (num <- 2 until n) {
            if (!seen(num)) {
                result += 1
                
                // mark the multiples of this number as seen
                var multiplier = 1
                var product = num
                while (product < n) {
                    seen(product) = true
                    product = num * multiplier
                    multiplier += 1
                }
            }
        }
        return result
    }
}







