//0ms







object Solution {
    def trailingZeroes(n: Int): Int = {
        return n/3125+n/625+n/125+n/25+n/5
    }
}






//0ms






object Solution:
  def trailingZeroes(n: Int): Int =
    @annotation.tailrec
    def byfive(count: Int, n: Int): Int =
      if n < 5 then count else byfive(count + n / 5, n / 5)
    byfive(0, n)
  end trailingZeroes
end Solution
