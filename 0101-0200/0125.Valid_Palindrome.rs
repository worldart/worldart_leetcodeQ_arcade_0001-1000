//0ms


impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        let mut iter = s
            .chars()
            .filter(|c| c.is_alphanumeric())
            .map(|c| c.to_ascii_lowercase());

        iter.clone().eq(iter.rev())
    }
}
