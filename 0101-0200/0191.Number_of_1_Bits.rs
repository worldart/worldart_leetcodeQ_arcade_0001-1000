//0ms 





impl Solution {
    pub fn hamming_weight(mut n: i32) -> i32 {
        let mut k = 0;
        while n > 0 {
            k += n % 2;
            n >>= 1;
        }
        k
    }
}







//0ms






impl Solution {
    pub fn hamming_weight(n: i32) -> i32 {
        let mut n = n;
        let mut ans = 0;
        while n > 0 {
            ans += n & 1;
            n >>= 1;
        }
        ans
    }
}






//0ms






impl Solution {
    pub fn hamming_weight (n: i32) -> i32 {
        n.count_ones() as i32
    }
}
