//0ms






const MAX: usize = 10_001;

const fn trails() -> [usize; MAX] {
    let mut ret = [0; MAX];
    let mut n = 1usize;

    while n < MAX {
        let mut zeroes = 0;
        let mut fives = 5;

        while n / fives > 0 {
            zeroes += n / fives;
            fives *= 5;
        }
        ret[n] = zeroes;
        n += 1;
    }
    ret
}

const TRAILS: [usize; MAX] = trails();

impl Solution {
    pub fn trailing_zeroes(n: i32) -> i32 {
        TRAILS[n as usize] as _
    }
}






//0ms






impl Solution {
  pub fn trailing_zeroes(n: i32) -> i32 {
    if n < 5 {
      return 0;
    }

    let mut count = 0;
    let mut num = n;
    while num >= 5 {
      num /= 5;
      count += num;
    }
    count
  }
}
