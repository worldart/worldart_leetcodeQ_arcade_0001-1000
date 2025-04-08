//43.88%RT

class Solution {
public:
    void findPermutation(vector<int>& nums, set<vector<int>>&ans, int i){
        // Base Case:
        if(i>=nums.size()){
            ans.insert(nums);
            return;
        }    
        // Swapping
        for(int j=i; j<nums.size(); j++){
            // Swap
            swap(nums[i], nums[j]);
            // Recusrive call
            findPermutation(nums, ans, i+1);
            // Backtracking - to recreate the original input string
            swap(nums[i], nums[j]);
        }
    }

    vector<vector<int>> permute(vector<int>& nums) {
        set<vector<int>> ans;
        int i=0;
        findPermutation(nums, ans, 0);
        vector<vector<int>> res;
        for(auto it: ans) res.push_back(it);
        return res;
    }
};
