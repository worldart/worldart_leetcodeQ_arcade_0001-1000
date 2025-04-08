//90.06%RT

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& a) {
        sort(a.begin(), a.end());
        vector<vector<int>> ans = {a[0]};

        for (int i = 1; i < a.size(); i++) {
            if (ans.back()[1] >= a[i][0]) {
                ans.back()[1] = max(ans.back()[1], a[i][1]);
            } else {
                ans.push_back(a[i]);
            }
        }
        return ans;
    }
};
