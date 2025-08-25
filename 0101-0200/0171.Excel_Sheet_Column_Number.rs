//0ms





impl Solution {
    pub fn title_to_number(column_title: String) -> i32 {
        column_title.bytes().fold(0, |acc, b| acc * 26 + (b - 64) as i32)
    }
}





//0ms






fn alpha_to_num(c: char) -> i32 {
    (c as i32) - ('A' as i32) + 1
}
impl Solution {
    pub fn title_to_number(column_title: String) -> i32 {
        let mut acc: i32 = 0;
        for c in column_title.chars() {
            acc = 26 * acc + alpha_to_num(c);
        }

        return acc;
    }
}
