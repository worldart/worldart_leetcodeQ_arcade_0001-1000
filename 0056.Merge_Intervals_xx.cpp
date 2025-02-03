//100%RT

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        int n = intervals.size();

        //sorting the input vector
        sort(intervals.begin(), intervals.end());
        vector<vector<int>> result;

        for(int i=0; i<n; ++i){

            /*
            if result is empty we push the first pair,
            or if the first element is greater than the second of
            previous they are non intersecting and we push the pair
            */
            if(result.empty() || result.back()[1]<intervals[i][0]){
                result.push_back(intervals[i]);
            }
            //else we change the second element as per the max element of both
            else{
                result.back()[1] = max(result.back()[1], intervals[i][1]);
            }
        }
        return result;
    }
};
