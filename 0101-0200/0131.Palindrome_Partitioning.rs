//21ms



impl Solution {
    fn partition(s: String) -> Vec<Vec<String>> {
        // backtracking 
        // 1. define `ans` to hold `candidates`
        let mut ans = Vec::new();
        // 2. define `candidates` to hold all potential candidates (palindromic substring)
        let mut candidates = Vec::new();
        // 3. start backtrack from index 0
        Solution::backtrack(&s, &mut ans, &mut candidates, 0);
        // 4. return ans
        ans
    }

    fn backtrack(s: &String, ans: &mut Vec<Vec<String>>, candidates: &mut Vec<String>, start: usize) {
        // 1. check if the goal is fulfilled, 
        // i.e. reaching the end of string in this problem
        if start == s.len() {
            // if so, we push `candidates` to ans since we've processed all characters
            ans.push(candidates.clone());
            return;
        }
        // 2. find all potential candidates
        for i in start..s.len() {
            // we want to test all substrings, each substring is a potential candidate
            // e.g. "aab" -> "a", "a", "b", "ab", "aa", "b", "aab"
            let candidate = &s[start .. i + 1];
            // 3. check if the current candidate is palindrome or not 
            // if not, then we cannot push to `candidates`
            if !Solution::is_palindrome(candidate) {
                continue;
            }
            // 4. if so, push it to candidates
            candidates.push(candidate.to_string());
            // 5. backtrack with index + 1
            Solution::backtrack(s, ans, candidates, i + 1);
            // 6. remove the current substring from `candidates`
            candidates.pop();
        }
    }

    fn is_palindrome(s: &str) -> bool {
        s.chars().eq(s.chars().rev())
    }
}




//16ms




impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        Self::partition_real(&s)
    }

    fn partition_real(s: &str) -> Vec<Vec<String>> {
        if s.is_empty() {
            return vec![];
        }

        let mut result = vec![];
        let mut stack = vec![];

        Self::partition_recursive(s, &mut result, &mut stack);

        result
    }

    fn partition_recursive<'a>(
        s: &'a str,
        result: &mut Vec<Vec<String>>,
        stack: &mut Vec<&'a str>,
    ) {
        if s.is_empty() {
            result.push(stack.iter().map(|s| s.to_string()).collect());
        }

        for split in 1..=s.len() {
            let (prefix, rest) = s.split_at(split);

            if !Self::is_palindrome(prefix) {
                continue;
            }

            stack.push(prefix);
            Self::partition_recursive(rest, result, stack);
            stack.pop();
        }
    }

    fn is_palindrome(s: &str) -> bool {
        let mut left = 0;
        let mut right = s.len() - 1;

        while left < right {
            if s.as_bytes()[left] != s.as_bytes()[right] {
                return false;
            }

            left += 1;
            right -= 1;
        }

        true
    }
}




//19ms




impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        let chars: Vec<char> = s.chars().collect();
        let mut answer = Vec::new();
        Self::helper(
            0,
            &mut Vec::new(),
            &mut answer,
            &chars,
        );
        answer
    }

    fn helper(
        index: usize,
        answer_cache: &mut Vec<String>,
        answer: &mut Vec<Vec<String>>,
        chars: &[char],
    ) {
        if index == chars.len() {
            answer.push(answer_cache.clone());
            return;
        }
        let mut end = index + 1;
        for end in (index + 1)..(chars.len() + 1) {
            if Self::is_palindrome(&chars[index..end]) {
                answer_cache.push(
                    chars[index..end].iter().collect()
                );
                Self::helper(
                    end,
                    answer_cache,
                    answer,
                    chars,
                );
                answer_cache.pop();
            }
        }
    }

    fn is_palindrome(chars: &[char]) -> bool {
        let mid = chars.len() / 2;
        for i in 0..mid {
            if chars[i] != chars[chars.len() - i - 1] {
                return false;
            }
        }
        true
    }
}
