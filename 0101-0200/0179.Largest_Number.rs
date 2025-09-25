//0ms





impl Solution {
    pub fn largest_number(nums: Vec<i32>) -> String {
        // Convert all numbers to strings
        let mut num_strs: Vec<String> = nums.into_iter().map(|num| num.to_string()).collect();

        // Custom comparator to sort the strings
        num_strs.sort_by(|a, b| {
            let order1 = format!("{}{}", a, b);
            let order2 = format!("{}{}", b, a);
            order2.cmp(&order1) // Sort in descending order
        });

        // Join all sorted numbers into a single string
        let result = num_strs.join("");

        // Handle case where all numbers are "0"
        if result.starts_with('0') {
            "0".to_string()
        } else {
            result
        }
    }
}





//0ms





impl Solution {
    pub fn largest_number(nums: Vec<i32>) -> String {
        let mut s: Vec<String> = nums.into_iter().map(|x| x.to_string()).collect();
        s.sort_by(|a,b| (b.clone()+a).cmp(&(a.clone()+b)));
        if s[0] == "0" {"0".into()} else {s.concat()}
    }
}
