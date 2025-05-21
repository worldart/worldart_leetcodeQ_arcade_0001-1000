//0ms


impl Solution {
    pub fn single_number(nums: Vec<i32>) -> i32 {
       
       let mut  num= nums;
num.sort();
        if num.len()==1{
            return num[0] as i32;
        }
        if num[num.len()-1]!=num[num.len()-2]{
            return num[num.len()-1] as i32;
        }
        for i in 0..num.len()-1{
            if i==0 && num[i]!=num[i+1]{
                return num[i] as i32;
            }
            if i>0 && num[i]!=num[i+1] && num[i]!=num[i-1]{
                return num[i] as i32;
            }
        }
        return 0;
    }
}
