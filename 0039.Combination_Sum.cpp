//57.45RT

class Solution {
public:
vector<vector<int>>result;
void answer(vector<int>&cand,int t,int idx,vector<int>&subset){
    if(t==0){
        result.push_back(subset);
        return;
    }
    if(idx==cand.size()) return;
    if(cand[idx]<=t){
        subset.push_back(cand[idx]);
        answer(cand,t-cand[idx],idx,subset);
        subset.pop_back();

    }
    int j=idx+1;
    answer(cand,t,j,subset);
}
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(),candidates.end());
        vector<int>subset;
        result.clear();
        answer(candidates,target,0,subset);
        return result;
    }
};
