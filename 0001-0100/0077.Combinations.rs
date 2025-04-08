//6ms 78.95%

impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        let mut result:Vec<Vec<i32>> = Vec::new();
        let mut combination:Vec<i32> = Vec::new();
        Self::backtrack(n,k,&mut result,&mut combination,1);
        result
    }
    fn backtrack(n:i32, k:i32 , result:&mut Vec<Vec<i32>>,combination:&mut Vec<i32>,start:i32){
        if(combination.len()==k as usize){
            result.push(combination.clone());
            return;
        }
        for i in start..=n {
            combination.push(i);
            Self::backtrack(n,k,result,combination,i+1);
            combination.pop();
        }
    }
}


/*

impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        let n = n as usize;
        let k = k as usize;
        let mut ans: Vec<Vec<i32>> = vec![];
        let mut prefix: Vec<i32> = vec![];
        binomial(n, 0, k, &mut prefix, &mut ans);
        ans
    }
}

fn binomial(n: usize, s: usize, k: usize, prefix: &mut Vec<i32>, ans: &mut Vec<Vec<i32>>) {
    if k == 0 {
        ans.push(prefix.clone());
        return;
    }
    if n - s < k {
        return;
    }
    for i in s..n {
        prefix.push(i as i32 + 1);
        binomial(n, i + 1, k - 1, prefix, ans);
        prefix.pop();
    }
}
*/


