//2ms






impl Solution {
    pub fn is_happy(mut n: i32) -> bool {
        let digits = |mut n| {
            std::iter::from_fn(move || {
                if n != 0 {
                    let r = n % 10;
                    n = n / 10;
                    Some(r)
                } else {
                    None
                }
            })
        };

        // i32::MAX = 2_147_483_647
        let max = 2 * 2 + 9 * 9 * 9;
        for _ in 0 ..= max {
            n = digits(n).map(|x| x * x).sum();
            if n == 1 {
                return true;
            }
        }
        return false;
    }
}






//0ms







impl Solution {
    pub fn is_happy(n: i32) -> bool {
        fn process(n: i32) -> i32 {
            if n == 0 {
                0
            } else {
                (n % 10) * (n % 10) + process(n/10)
            }
        }
        let (mut slow, mut fast) = (n, n);
        loop {
            slow = process(slow);
            fast = process(process(fast));
            // println!("{} {}", slow, fast);
            if slow == 1 || fast == 1 {
                return true;
            }
            if slow == fast {
                break;
            }
        }
        false
    }
}






//0ms






use std::collections::HashSet;

impl Solution {
    pub fn is_happy(mut n: i32) -> bool {
        let mut seen = HashSet::new();

        while n != 1 {
            if seen.contains(&n) {
                return false;
            }
            seen.insert(n);

            let mut sum = 0;
            while n > 0 {
                let digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
        }

        true
        }
}





//0ms





impl Solution {
    pub fn is_happy(n: i32) -> bool {
        //n桁の数は81*n以下になるので1ループの最大値は810以下
        //1000回やって1に到達しないならループしてる
        let mut tmp = n;
        for i in 0..1000 {
            let mut new = 0;
            while tmp > 0 {
                let digit = tmp % 10;
                new += digit * digit;
                tmp /= 10;
            }
            tmp = new;
        }
        if tmp == 1 {true} else {false}
    }
}
