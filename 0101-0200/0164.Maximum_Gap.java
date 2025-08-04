//40ms





class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        
        Arrays.sort(nums);
        int maxDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }
}







//7ms







class Solution {
    public int maximumGap(int[] nums) {
        int n=nums.length;
        if(n<2){
            return 0;
        }
        if(n==2){
            return Math.abs(nums[1]-nums[0]);
        }
        int res= bucketSort(nums);
        return res;
    }

    public int bucketSort(int[] arr){
        int n=arr.length;
        int max = 0, min = Integer.MAX_VALUE;

        for(int i: arr){
            if(i>max) max =i;
            if(i<min) min=i;
        }
        if(max == min)
            return 0;
        
        int bucketSize = (max - min)/n + 1;  
        int bucketCount = (max-min)/bucketSize + 1;
        int[] minBucket = new int[bucketCount];
        int[] maxBucket = new int[bucketCount];

        Arrays.fill(minBucket,Integer.MAX_VALUE);
        for(int x:arr){
            int index = (x - min) / bucketSize;
            minBucket[index] = Math.min(minBucket[index], x);
            maxBucket[index] = Math.max(maxBucket[index], x);
        }

        int prevMax = maxBucket[0], result = 0;
        for(int i = 1; i < bucketCount; ++i) {
            if(minBucket[i] == Integer.MAX_VALUE)
                continue;
            result = Math.max(result, minBucket[i] - prevMax);
            prevMax = maxBucket[i];
        }
        return result;
    }
}







//7ms







public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min == max) {
            return 0;
        }
        int bucketSize = (int) Math.ceil((double) (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            bucketMin[i] = Integer.MAX_VALUE;
            bucketMax[i] = Integer.MIN_VALUE;
        }
        for (int num : nums) {
            int bucketIndex = (num - min) / bucketSize;
            bucketMin[bucketIndex] = Math.min(bucketMin[bucketIndex], num);
            bucketMax[bucketIndex] = Math.max(bucketMax[bucketIndex], num);
        }
        int maxGap = 0;
        int prevMax = min;
        for (int i = 0; i < bucketCount; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }
        return maxGap;
    }
}
