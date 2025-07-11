//0ms



class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[start] <= nums[end]) {
                // It's already in sorted order. Then the first element is the minimum.
                ans = Math.min(ans, nums[start]);
                break;
            }

            if (nums[start] <= nums[mid]) {
                // The start element is the minimum of the entire left half. Store and move to the right.
                ans = Math.min(ans, nums[start]);
                start = mid + 1;
            } else {
                // Possible that we are in two halves of rotated array. Store and move left.
                ans = Math.min(ans, nums[mid]);
                end = mid - 1;
            }
        }
        return ans;
    }
}






//0ms






class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
         
    if(nums[0]<=nums[nums.length-1]){
                 return nums[0];
          }
        while(start<end){
            int mid= (start+end)/2;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid]>nums[start]){
                start= mid+1;
            }else{
                end=mid;
            }
        }
        return nums[start];
        
    }
}


