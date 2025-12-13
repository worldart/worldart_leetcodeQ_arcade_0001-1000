//1ms





object Solution {
    // you need treat n as an unsigned value
    def hammingWeight(n: Int, weight: Int = 0): Int =
        if (n != 0) hammingWeight(n & n - 1, weight + 1) else weight
}







//0ms







object Solution {
    def hammingWeight(n: Int): Int = {
        hamming(0, n)
    }

    @annotation.tailrec def hamming(current: Int, n: Int): Int = {
        if (n == 0) current
        else if (n == 1) current + 1
        else {
            val x = n / 2
            val r = n % 2
            hamming(r + current, x)
        }
    }
}



//In Scala, @annotation.tailrec (commonly written as @tailrec) is a compiler annotation used to enforce tail recursion.

//A function is tail-recursive if the recursive call is the final operation—nothing is done with its result.
