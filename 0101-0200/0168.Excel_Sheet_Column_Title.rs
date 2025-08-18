//0ms







impl Solution {
    pub fn convert_to_title(mut column_number: i32) -> String {
        let mut result = Vec::<char>::new();

        while column_number > 0 {
            column_number -= 1;
            result.push(Solution::i32_to_char_upper(column_number % 26));
            column_number /= 26;
        }

        String::from_iter(result.into_iter().rev())
    }

    #[inline]
    fn i32_to_char_upper(n: i32) -> char {
        (b'A' + n as u8) as char
    }
}






//0ms






impl Solution {
    pub fn convert_to_title(column_number: i32) -> String {
            let mut s = String::new();
    let mut n = column_number;
    let a = 65;
    while n > 0 {
        n -= 1;
        let c = n % 26;
        s.push(char::from_u32((a + c) as u32).unwrap());
        n = (n as f64 / 26 as f64).floor() as i32;
    }
    s.chars().rev().collect()
    }
}
