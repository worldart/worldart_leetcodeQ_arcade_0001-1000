//29.41%RT

class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        sort(candidates.begin(), candidates.end());
        queue<tuple<vector<int>, int, int>> q;
        q.push({{}, 0, 0});

        while (!q.empty()) {
            auto [combination, currentSum, startIndex] = q.front();
            q.pop();

            if (currentSum == target) {
                ans.push_back(combination);
                continue;
            }

            for (int i = startIndex; i < candidates.size(); i++) {
                int newSum = currentSum + candidates[i];
                if (newSum > target) break;
                vector<int> newCombination = combination;
                newCombination.push_back(candidates[i]);
                q.push({newCombination, newSum, i});
            }
        }

        return ans;
    }
};
//Iterative (Queue-Based BFS)
