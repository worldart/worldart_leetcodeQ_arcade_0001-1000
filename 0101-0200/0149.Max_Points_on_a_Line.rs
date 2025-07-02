//5ms






use std::collections::HashMap;

impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i32 {
        let mut hash: HashMap<(i64, i64), i32> = HashMap::new();
        for i in 1..points.len() {
            for j in 0..i {
                let x_diff = points[i][0] - points[j][0];
                let y_diff = points[i][1] - points[j][1];
                let (slope, intercept) = if x_diff == 0 {
                    (f64::INFINITY, points[i][0] as f64)
                }
                else {
                    let s = y_diff as f64 / x_diff as f64;
                    let c = points[i][1] as f64 - s * points[i][0] as f64;
                    (s, c)
                };
                let key = (Self::amplify(slope), Self::amplify(intercept));
                *hash.entry(key).or_insert(0) += 1;
            }
        }
        match hash.values().max() {
            None => 1,
            Some(&val) => (val as f64 * 2.0).sqrt() as i32 + 1,
        }
    }

    fn amplify(val: f64) -> i64 {
        (val * 1_000_000_000_000.0).round() as i64
    }
}







//2ms







use std::collections::HashMap;

impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i32 {
        let n = points.len();
        if n <= 2 { return n as i32; }
        
        let mut result = 2;
        let mut map = HashMap::new();
        
        for i in 0..n - 1 {
            map.clear();
            let mut duplicates = 0;
            let mut max_count = 0;
            
            let (x1, y1) = (points[i][0], points[i][1]);
            
            for j in i + 1..n {
                let (x2, y2) = (points[j][0], points[j][1]);
                let dx = x2 - x1;
                let dy = y2 - y1;
                
                if dx | dy == 0 {
                    duplicates += 1;
                    continue;
                }
                
                let slope = if dx == 0 {
                    0i64  // Vertical line
                } else if dy == 0 {
                    1i64  // Horizontal line
                } else {
                    // Ultra-fast GCD and packing
                    let g = fast_gcd(dx.abs(), dy.abs());
                    let nx = dx / g;
                    let ny = dy / g;
                    
                    if nx > 0 {
                        ((nx as i64) << 32) | ((ny as u32) as i64)
                    } else {
                        ((-nx as i64) << 32) | ((-ny as u32) as i64)
                    }
                };
                
                max_count = max_count.max(*map.entry(slope).and_modify(|e| *e += 1).or_insert(1));
            }
            
            result = result.max(max_count + 1 + duplicates);
        }
        
        result
    }
}

#[inline]
fn fast_gcd(mut a: i32, mut b: i32) -> i32 {
    if b == 0 { return a; }
    
    // Unrolled first few iterations for speed
    if a >= b {
        a %= b;
        if a == 0 { return b; }
    }
    
    loop {
        b %= a;
        if b == 0 { return a; }
        a %= b;
        if a == 0 { return b; }
    }
}







//3ms







use std::collections::HashMap;

impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i32 {
        let n = points.len();
        if n <= 2 {
            return n as i32;
        }
        
        let mut max_points = 2;
        
        // For each point, count how many other points lie on the same line
        for i in 0..n {
            let mut slope_count = HashMap::new();
            let mut duplicate = 0;
            let mut vertical = 0;
            let mut current_max = 0;
            
            for j in (i + 1)..n {
                let dx = points[j][0] - points[i][0];
                let dy = points[j][1] - points[i][1];
                
                if dx == 0 && dy == 0 {
                    // Same point
                    duplicate += 1;
                } else if dx == 0 {
                    // Vertical line
                    vertical += 1;
                    current_max = current_max.max(vertical);
                } else {
                    // Calculate slope and reduce to lowest terms
                    let g = gcd(dx.abs(), dy.abs());
                    let normalized_dx = dx / g;
                    let normalized_dy = dy / g;
                    
                    // Ensure consistent representation (make dx positive)
                    let (slope_dx, slope_dy) = if normalized_dx < 0 {
                        (-normalized_dx, -normalized_dy)
                    } else {
                        (normalized_dx, normalized_dy)
                    };
                    
                    let slope = (slope_dx, slope_dy);
                    let count = slope_count.entry(slope).or_insert(0);
                    *count += 1;
                    current_max = current_max.max(*count);
                }
            }
            
            // Add 1 for the reference point itself, plus any duplicates
            max_points = max_points.max(current_max + 1 + duplicate);
        }
        
        max_points
    }
}

// Helper function to calculate GCD
fn gcd(a: i32, b: i32) -> i32 {
    if b == 0 {
        a
    } else {
        gcd(b, a % b)
    }
}
