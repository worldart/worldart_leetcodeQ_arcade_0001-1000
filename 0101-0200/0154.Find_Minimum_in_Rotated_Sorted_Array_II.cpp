//0ms




class Solution {
public:
    //----------Optimal Approach----------//
    int findMin(vector<int>& nums) {
        int n = nums.size();
        int min_ele = nums[0];
        int low = 0, high = n - 1;

        if (n == 1)
            return nums[0];

        while (low <= high) {
            int rem_ele = high - low + 1;
            int mid = (low + high) / 2;

            // Case when all three are equal and we can't decide the sorted half
            if (rem_ele > 3 && nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                min_ele = min(min_ele, nums[low]);
                low = mid + 1;
            }
            // Right half is sorted
            else {
                min_ele = min(min_ele, nums[mid]);
                high = mid - 1;
            }
        }

        return min_ele;
    }
};





//0ms






class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size();
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                ans = nums[i];
            }
        }
        return ans;
    }
};
