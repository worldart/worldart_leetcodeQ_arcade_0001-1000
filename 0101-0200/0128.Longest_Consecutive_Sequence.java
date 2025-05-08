//60ms




public int longestConsecutive(int[] num) {
    int res = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int n : num) {
        if (!map.containsKey(n)) {
            int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
            int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
            // sum: length of the sequence n is in
            int sum = left + right + 1;
            map.put(n, sum);
            
            // keep track of the max length 
            res = Math.max(res, sum);
            
            // extend the length to the boundary(s)
            // of the sequence
            // will do nothing if n has no neighbors
            map.put(n - left, sum);
            map.put(n + right, sum);
        }
        else {
            // duplicates
            continue;
        }
    }
    return res;
}




//25ms




class Solution {
public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int ans = 0;
        for(int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while(set.remove(left)) left--;
            while(set.remove(right)) right++;
            ans = Math.max(ans,right - left - 1);
            if(set.isEmpty()) return ans;//save time if there are items in nums, but no item in hashset.
        }
        return ans;
    }
}





//17ms





public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);//O(nlgn);
        int curr = nums[0];
        int sum = 1;
        int ans = 1;
        for(int i = 1;i< nums.length;i++){
            if(nums[i] == nums[i - 1]) continue;
            if(nums[i] == curr + 1){
                curr++;
                sum++;
                ans = Math.max(ans,sum);
            }else{
                curr = nums[i];
                sum = 1;
            }
        }
        return ans;
    }





