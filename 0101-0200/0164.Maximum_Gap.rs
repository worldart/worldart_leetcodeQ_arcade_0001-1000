//4ms





impl Solution {
    pub fn maximum_gap(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let (mut min, mut max) = (i32::MAX, i32::MIN);

        for &num in &nums {
            (min, max) = (min.min(num), max.max(num));
        }
        if min == max {
            return 0;
        }
        #[derive(Clone, Copy)]
        struct Bucket { min: i32, max: i32 }

        let mut buckets = vec![Option::<Bucket>::None; n + 1];

        let delta = ((max - min) as usize + n - 1) / n;

        for num in nums {
            match &mut buckets[(num - min) as usize / delta] {
                Some(bkt) => {
                    bkt.min = bkt.min.min(num);
                    bkt.max = bkt.max.max(num);
                },
                bkt => {
                    bkt.insert(Bucket { min: num, max: num });
                },
            }
        }
        let mut prev = min;
        let mut gap  = 0;

        for bucket in buckets.into_iter().flatten() {
            gap  = gap.max(bucket.min - prev);
            prev = bucket.max;
        }
        gap
    }
}






//1ms






impl Solution {
    pub fn maximum_gap(nums: Vec<i32>) -> i32 {
        let size = nums.len();
        let mut min_val = i32::MAX;
        let mut max_val = i32::MIN;
        for i in 0..size {
            if max_val < nums[i] {
                max_val = nums[i];
            }
            if min_val > nums[i] {
                min_val = nums[i];
            }
        }
        if min_val == max_val {
            return 0;
    }
        let bucket_size = 1.max((max_val - min_val) as usize / (size - 1)); //เมื่อเรียงลำดับตัวเลข n ตัวจะมีช่องว่างระหว่างตัวเลขที่อยู่ติดกันทั้งหมด n-1 ช่อง (average gap)
        let bucket_num = (max_val - min_val) as usize / bucket_size + 1;
        let mut bucket_largest = vec![i32::MIN; bucket_num];
        let mut bucket_smallest = vec![i32::MAX; bucket_num];
        for i in 0..size {
            let index = (nums[i] - min_val) as usize / bucket_size;
            bucket_largest[index] = bucket_largest[index].max(nums[i]);
            bucket_smallest[index] = bucket_smallest[index].min(nums[i]);
        }

        let mut max_gap = 0;
        let mut i = 0;
        let mut j = 1;
        while j < bucket_num {
            if bucket_largest[j] == i32::MIN {
                j+=1;
            }
            else if bucket_largest[i] == i32::MIN {
                i+=1;
            }
            else{
                max_gap = max_gap.max(bucket_smallest[j] - bucket_largest[i]);
                i+=1;
                j+=1;
            }
        }
        return max_gap;
    }
}
