//496ms




object Solution {
    // you need treat n as an unsigned value
    def reverseBits(x: Int): Int = {
        
        var n = x
        var res = 0
        
        (0 until 32).foreach { i =>
            res += n & 1
            n >>>= 1
            if (i < 31) {
                res <<= 1
            }
        }
        res
    }
}





//491ms





object Solution:
    def reverseBits(_n: Int): Int =
        val n = _n.toLong
        var acc: Long = 
            ((n & 0x000000ff) << 24) |
            ((n & 0x0000ff00) << 8) |
            ((n & 0x00ff0000) >> 8) |
            ((n & 0xff000000) >> 24)
        acc = ((acc & 0x0f0f0f0f) << 4) | ((acc & 0xf0f0f0f0) >> 4)
        acc = ((acc & 0x33333333) << 2) | ((acc & 0xcccccccc) >> 2)
        acc = ((acc & 0x55555555) << 1) | ((acc & 0xaaaaaaaa) >> 1)
        acc.toInt
