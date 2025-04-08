//0ms

impl Solution {
    pub fn num_trees(n: i32) -> i32 {
        catalan(n as f64) as i32
    }
}

fn catalan(n: f64) -> f64 {
    if n <= 1.0 { 1.0 }
    else {
       2.0*(2.0* n - 1.0)/(n + 1.0) * catalan(n - 1.0)
    }
}
