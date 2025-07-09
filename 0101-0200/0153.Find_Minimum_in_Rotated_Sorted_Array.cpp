//0ms





class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0, high = nums.size() - 1, mini = INT_MAX;
        while (low <= high) {
            int mid = (low + high) / 2;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                mini = min(mini, nums[low]);
                low = mid + 1;
            }
            // Right half is sorted
            else {
                mini = min(mini, nums[mid]);
                high = mid - 1;
            }
        }
        return mini;
    }
};






//0ms






class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
};
//2:04
