//100%RT

class Solution {
public:
    void backtrack(int idx, vector<int>& candidates, int target, vector<int>& curr, vector<vector<int>>& ans) {
        if (target == 0) {
            ans.push_back(curr);
            return;
        }

        for (int i = idx; i < candidates.size(); i++) {
            if (candidates[i] > target) break; // Prune invalid paths
            curr.push_back(candidates[i]);    // Choose the candidate
            backtrack(i, candidates, target - candidates[i], curr, ans); // Reuse the same candidate
            curr.pop_back();                  // Backtrack to try other paths
        }
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> curr;
        sort(candidates.begin(), candidates.end());
        backtrack(0, candidates, target, curr, ans);
        return ans;
    }
};
//Backtracking (Most Optimal Solution)
