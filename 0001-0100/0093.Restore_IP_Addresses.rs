//0ms

// ideas:
// A valid ip address would have 4 parts separated by dots
// we iterate through `s` to insert 3 dots and separate the string into 4 segments
// for each segment, we check if it is valid
// if all 4 segments are valid, we combine those 4 segments with dots and push to the answer

impl Solution {
    fn restore_ip_addresses(s: String) -> Vec<String> {
        let mut ans = vec![];
        let n = s.len();
        // iterate `s` - place 3 dots to have 4 segments 
        // [seg1].[seg2].[seg3].[seg4]
        // 1st dot - we just need to run it 3 times at most
        // e.g. for 255, we can place the first dot at `2.55`, `25.5` or `255.`
        for i in 1 .. 4 {
            // we place the 2nd dot in a similar way
            for j in i + 1 .. i + 4 {
                // we place the 3rd dot in a similar way
                for k in j + 1 .. j + 4 {
                    if k < n {
                        // now we can separate into 4 segments
                        let seg1 = &s[..i];
                        let seg2 = &s[i..j];
                        let seg3 = &s[j..k];
                        let seg4 = &s[k..];
                        // for each segment, check if it is valid
                        if Solution::ok(seg1) && 
                           Solution::ok(seg2) && 
                           Solution::ok(seg3) && 
                           Solution::ok(seg4) {
                            // if so, we build the ip address and push to answer
                            ans.push(format!("{}.{}.{}.{}", seg1, seg2, seg3, seg4));
                        }
                    }
                }
            }
        }
        ans
    }

    // check if a given IP address segment is valid
    // 192 -> true
    // 312 -> false
    fn ok(seg: &str) -> bool {
        seg.len() > 0 && seg.len() <= 3 && !(seg.starts_with('0') && seg.len() > 1) && seg.parse::<u32>().unwrap() <= 255
    }
}
