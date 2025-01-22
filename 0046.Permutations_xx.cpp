//100%RT


class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<int> ds;
        int freq[nums.size()];

        for (int i = 0; i < nums.size(); i++)
            freq[i] = 0;

        vector<vector<int>> ans;
        recursivePermute(nums, ds, freq, ans);

        return ans;
    }

private:
    void recursivePermute(vector<int>& nums, vector<int>& ds, int freq[],
                          vector<vector<int>>& ans) {
        if (ds.size() == nums.size()) {
            ans.push_back(ds);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (freq[i] != 1) {
                ds.push_back(nums[i]);
                freq[i] = 1;
                recursivePermute(nums, ds, freq, ans);
                freq[i] = 0;
                ds.pop_back();
            }
        }
    }
};
