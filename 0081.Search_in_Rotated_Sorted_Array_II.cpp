//0ms


class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int low1 = 0, high1 = nums.size() - 1, pivot;

        while (low1 < high1) {
            int mid = (low1 + high1) / 2;
            if (nums[mid] > nums[high1]) low1 = mid + 1;
            else if(nums[mid] < nums[high1]) high1 = mid;
            else {
                if (nums[high1 - 1] > nums[high1]) {
                low1 = high1;
                break;
                }
                high1--;
            }
        }
        pivot = low1;

        int low = 0, high = nums.size() - 1;
    
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int mid2 = (mid + pivot) % nums.size();

            if(nums[mid2] == target) return true;
            else if (nums[mid2] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
};
