//0ms


impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        let mut second_last = 0;
        let mut last = 1;
        for _ in 1..=n {
            let temp = last;
            last = second_last + last;
            second_last = temp;
        }
        last
    }
}
