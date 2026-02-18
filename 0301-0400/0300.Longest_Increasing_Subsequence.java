//51ms






public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = Arrays.stream(dp).max().orElse(0);
        return maxLength;
    }
}





//10ms






class Solution{
    public int lengthOfLIS(int[] nums){
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i = 1; i < nums.length; i++){

            if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
            }
            else{
                int left = 0;
                int right = list.size() - 1;

                while(left <= right){
                    int mid = left + (right - left) / 2;

                    if(list.get(mid) >= nums[i]){
                        right = mid - 1;
                    }
                    else{
                        left = mid + 1;
                    }
                }

                list.set(left, nums[i]);
            }
        }

        return list.size();
    }
}
