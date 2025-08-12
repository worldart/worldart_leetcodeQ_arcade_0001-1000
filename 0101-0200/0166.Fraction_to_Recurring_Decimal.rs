//0ms






use std::collections::HashMap;

impl Solution {
    pub fn fraction_to_decimal(numerator: i32, denominator: i32) -> String {
        if numerator == 0 {
            return "0".to_string();
        }

        let mut result = String::new();

        // Handle sign
        let negative = (numerator < 0) ^ (denominator < 0);
        if negative {
            result.push('-');
        }

        let numerator_abs = (numerator as i64).abs();
        let denominator_abs = (denominator as i64).abs();

        // Integer part
        result.push_str(&(numerator_abs / denominator_abs).to_string());

        let mut remainder = numerator_abs % denominator_abs;
        if remainder == 0 {
            return result;
        }

        result.push('.');

        let mut seen: HashMap<i64, usize> = HashMap::new();

        while remainder != 0 {
            if let Some(&pos) = seen.get(&remainder) {
                result.insert(pos, '(');
                result.push(')');
                break;
            }
            seen.insert(remainder, result.len());

            remainder *= 10;
            let digit = remainder / denominator_abs;
            result.push_str(&digit.to_string());
            remainder %= denominator_abs;
        }

        result
    }
}








//0ms






use std::collections::HashMap;

impl Solution {
  fn insert_char(original: &str, index: usize, ch: char) -> String {
    let mut chars: Vec<char> = original.chars().collect();
    chars.insert(index, ch);
    chars.iter().collect()
}
  pub fn fraction_to_decimal(numerator: i32, denominator: i32) -> String {
    let mut neg = false;
    let mut numerator:i64 = numerator as i64;
    let mut denominator:i64 = denominator as i64;
    if numerator < 0 { neg = true; numerator = numerator*-1; }
    if denominator < 0 { neg = !neg; denominator = denominator*-1; }
    if numerator == 0 { return "0".to_string() }
    let mut res = "0.".to_string();
    let mut num = numerator*10;
    if numerator >= denominator {
      if numerator % denominator == 0 {
        if neg {
            return (-1*numerator / denominator).to_string()
        } else {
            return (numerator / denominator).to_string()
        }
      } else {
        res = (numerator/denominator).to_string() + ".";
        num = (numerator % denominator)*10;
      }
    }


    let mut hm: HashMap<i64, usize> = HashMap::new();
    let mut idx = res.len();
    loop {
      if hm.contains_key(&num) {
        res+=")";
        let newres = Self::insert_char(&res, hm[&num], '(');
        res = newres;
        if neg {
            let newres = Self::insert_char(&res, 0, '-');
            return newres
          } else {
            return res
          }
      }
      *hm.entry(num).or_insert(idx) = idx;
      idx+=1;
      if num < denominator {

        res+="0";
        num*=10;
      } else {
        let rem = num%denominator;
        res+=&(num/denominator).to_string();
        num = rem*10;
        if rem == 0 {
          if neg {
            let newres = Self::insert_char(&res, 0, '-');
            return newres
          } else {
            return res
          }
        }
      }
    }
    res
  }
}







//0ms







impl Solution {
    pub fn fraction_to_decimal(numerator: i32, denominator: i32) -> String {
        if numerator == 0 || denominator == 0 {
            "0".into()
        } else {
            let mut s = String::new();
            if numerator.signum() * denominator.signum() < 0 {
                s.push('-');
            }
            let mut n = (numerator as i64).abs();
            let     d = (denominator as i64).abs();
            let mut i = 0;

            // Find the start of the cycle and its period.
            let cyc = floyd(|n| (n % d) * 10, n);
            let lam = cyc.0;
            let mu  = if cyc.1 != 0 { cyc.1 } else { cyc.1 + 1 };

            // Build the output string.
            while n != 0 && i < lam + mu {
                if i == 1 {
                    s.push('.');
                }
                if i == mu {
                    s.push('(');
                }
                s.push_str(&(n / d).to_string());
                n %= d;
                n *= 10;
                i += 1;
                if i == mu + lam {
                    s.push(')');
                }
            }
            s
        }
    }
}

/// Find the start of a cycle `mu` and its period `lam`.
/// Function returns `(lam, mu)` - period and start.
///
fn floyd<F>(f: F, x0: i64) -> (usize, usize) 
where
    F: Fn(i64) -> i64
{   
    let mut tort = f(x0);
    let mut hare = f(f(x0));
    let mut mu   = 0;
    let mut lam  = 1;

    while tort != hare {
        tort = f(tort);
        hare = f(f(hare));
    }
    tort = x0;
    while tort != hare {
        tort = f(tort);
        hare = f(hare);
        mu += 1;
    }
    hare = f(tort);
    while tort != hare {
        hare = f(hare);
        lam += 1;
    }
    (lam, mu)
}
