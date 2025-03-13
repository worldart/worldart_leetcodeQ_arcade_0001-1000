//0ms


impl Solution {
    pub fn gray_code(n: i32) -> Vec<i32> {
        (0..(1<<n)).map(into_gray).collect()
    }
}
#[inline]
fn into_gray(n : i32) -> i32 {
    n ^ (n >> 1)
}
