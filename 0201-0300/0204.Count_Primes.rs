//31ms





impl Solution {
    pub fn count_primes(n: i32) -> i32 {
        let n = n as usize;
        if n <= 2 { return 0; }
        
        let sqrted_n = (n as f64).sqrt() as usize;
        let mut validations = vec![true; n];
        validations[0] = false;
        validations[1] = false;

        for i in 2..=sqrted_n {
            if validations[i] {
                let mut j = i * i;
                while j < n {
                    validations[j] = false;
                    j += i;
                }
            }
        }
        validations.into_iter().filter(|&a| a).count() as i32
    }
}




//2ms




impl Solution {
    pub fn count_primes(n: i32) -> i32 {
        if n < 3 {
            return 0;
        }
        let n = n as i64;
        Self::prime_count(n - 1) as i32
    }

    // Count primes <= n using Lucy_Hedgehog's method (simplified Meissel-Lehmer)
    fn prime_count(n: i64) -> i64 {
        if n < 2 {
            return 0;
        }
        let sqrt = (n as f64).sqrt() as i64;
        let mut small = vec![0i64; (sqrt + 2) as usize];  // S[i] = count for value i
        let mut large = vec![0i64; (sqrt + 2) as usize];  // S[i] = count for value n/i

        // Initialize: S(v) = v - 1 (count of integers >= 2)
        for i in 1..=sqrt as usize {
            small[i] = i as i64 - 1;
            large[i] = n / i as i64 - 1;
        }

        let mut sieve = vec![false; (sqrt + 1) as usize];

        for p in 2..=sqrt as usize {
            if sieve[p] {
                continue;
            }
            // p is prime
            let p64 = p as i64;
            let pcnt = small[p - 1]; // number of primes < p
            let p2 = p64 * p64;

            // Update large values: n/1, n/2, ...
            for i in 1..=sqrt as usize {
                let val = n / i as i64;
                if val < p2 {
                    break;
                }
                let sub_val = val / p64;
                let sub = if sub_val <= sqrt {
                    small[sub_val as usize]
                } else {
                    large[i * p]
                };
                large[i] -= sub - pcnt;
            }

            // Update small values
            let mut j = sqrt as usize;
            while j as i64 >= p2 {
                let sub_val = j as i64 / p64;
                small[j] -= small[sub_val as usize] - pcnt;
                j -= 1;
            }

            // Mark composites
            let mut k = p * p;
            while k <= sqrt as usize {
                sieve[k] = true;
                k += p;
            }
        }

        large[1]
    }
}




//13ms





impl Solution {
    pub fn count_primes(n: i32) -> i32 {
        if n < 2 {
            return 0;
        }
        
        static MAX_N: usize = 5_000_001;
        static mut SHOULD_INIT: bool = true;
        static mut IS_PRIME: [u8; MAX_N] = [1; MAX_N];  // Changed to u8
        static mut PREFIX: [i32; MAX_N] = [0; MAX_N];

        unsafe {
            if SHOULD_INIT {
                IS_PRIME[0] = 0;
                IS_PRIME[1] = 0;

                let limit = (MAX_N as f64).sqrt() as usize + 1;

                for i in 2..=limit {
                    if IS_PRIME[i] == 1 {
                        // Start at i*i, not i*2 (KEY OPTIMIZATION!)
                        for j in (i * i..MAX_N).step_by(i) {
                            IS_PRIME[j] = 0;
                        }
                    }
                }

                for i in 1..MAX_N {
                    PREFIX[i] = PREFIX[i - 1] + IS_PRIME[i - 1] as i32;
                }

                SHOULD_INIT = false;
            }

            PREFIX[n as usize]
        }
    }
}







