//0ms


pub fn candy(ratings: Vec<i32>) -> i32 {
    let n = ratings.len();
    let mut allocation = vec![1; n];
    for i in 1..n {
        if ratings[i] > ratings[i - 1] {
            allocation[i] = allocation[i - 1] + 1;
        }
    }
    for i in (0..n - 1).rev() {
        if ratings[i] > ratings[i + 1] {
            allocation[i] = allocation[i].max(allocation[i + 1] + 1);
        }
    }
    allocation.iter().sum()
}


//0ms



impl Solution {
    pub fn candy(ratings: Vec<i32>) -> i32 {
        if ratings.len() == 1 {
            return 1;
        }
        let mut c =  vec![0; ratings.len()];
        let mut low = vec![];
        for i in 0..ratings.len() {
            if check(i, &ratings) {
                low.push(i);
            }
        }
        for &l in &low {
            // let mut s = l;
            for i  in (0..l).rev() {
                // if i+1 >= ratings.len() {
                //     continue;
                // }
                if ratings[i]> ratings[i+1]  {
                    c[i] = i32::max(c[i+1]+1, c[i]);
                } else {
                    break;
                }
            }
            for i  in (l+1)..ratings.len() {
                if ratings[i]> ratings[i-1] {
                    c[i] = i32::max(c[i-1]+1, c[i]);
                } else {
                    break;
                }
            }
        }
        println!("{:?}", low);
        c.iter().sum::<i32>()+ ratings.len() as i32

    }
}


fn check(i : usize, l: &Vec<i32>) -> bool{
    if i == 0 {
        return l[i]<= l[i+1];
    } else if i == l.len() -1 {
        return l[l.len()-2] >= l[i];
    } else {
        return l[i-1]>= l[i]&& l[i+1]>= l[i];
    }
}
