//509ms


impl Solution {
	pub fn min_cut(s: String) -> i32 {
		let s = s.as_bytes();
		let mut dp = vec![i32::MAX; s.len() + 1];
		dp[0] = -1;

		for i in 0..s.len() {
			for j in (0..=i).rev() {
				if Self::is_palindrome(&s[j..=i]) {
					dp[i + 1] = dp[i + 1].min(dp[j] + 1);
				}
			}
		}
		dp[s.len()]
	}
	fn is_palindrome(s: &[u8]) -> bool {
		let len = s.len();
		for i in 0..len/2 {
			if s[i] != s[len-i-1] {
				return false;
			}
		} true
	}
}



//0ms




impl Solution {
    pub fn min_cut(s: String) -> i32 {
        let n = s.len();
    if n <= 1 {
        return 0;
    }

    let s: Vec<char> = s.chars().collect();
    let mut cuts: Vec<i32> = (0..n as i32).collect();

    for i in 0..n {
        let mut l = i;
        let mut r = i;
        while l >= 0 && r < n && s[l] == s[r] {
            cuts[r] = if l == 0 { 0 } else { cuts[r].min(cuts[l - 1] + 1) };
            if l == 0 { break; }
            l -= 1;
            r += 1;
        }

        let mut l = i;
        let mut r = i + 1;
        while l >= 0 && r < n && s[l] == s[r] {
            cuts[r] = if l == 0 { 0 } else { cuts[r].min(cuts[l - 1] + 1) };
            if l == 0 { break; }
            l -= 1;
            r += 1;
        }
    }

    cuts[n - 1]
    }
}
