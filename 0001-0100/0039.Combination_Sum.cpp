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


/*

class Solution {
public:
    vector<vector<int>> ans; // 2 D vector to store our answer
    void solve(int i, vector<int>& arr, vector<int>& temp, int target)
    {
        // if our target becomes zero at any point, then yess!! we wil find a possible combination
        if(target == 0) 
        {
            ans.push_back(temp); // include that combination in our answer
            return; // and then return, we are now not gonna explore more possiblity
        }
        
        // if at any point target becomes less than zero, then simply return, saying that no it is notpossible to our target combination sum
        if(target < 0)
            return;
        
        // if index crosses the last index, we will return saying that no more element is left to choosee
        if(i == arr.size())
            return;
        
        // As we dicussed for every element we have two choices whether to include in our answer or not include in our answer. 
		//so now, we are doing that
        
        // we are not taking the ith element,
        // so without decreasing sum we will move to next index because it will not contribute in making our sum
        solve(i + 1, arr, temp, target);
        
        // we are taking the ith element and not moving onto the next element because it may be possible that this element again contribute in making our sum.
        // but we decrease our target sum as we are consediring that this will help us in making our target sum
        
        temp.push_back(arr[i]); // including ith element
        solve(i, arr, temp, target - arr[i]); // decreasing sum,and call again function
        temp.pop_back(); // backtrack
        
    }
    vector<vector<int>> combinationSum(vector<int>& arr, int target) {
        ans.clear(); // clear global array, make to sure that no garbage value is present in it
        
        vector<int> temp; // temporary vector that tries all possible combination
        
        solve(0, arr, temp, target); // calling function, and see we start from index zero
        
        return ans; // finally return the answer array
    }
};
//backtracking
*/
