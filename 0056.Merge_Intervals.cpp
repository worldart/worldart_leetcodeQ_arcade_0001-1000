//44.21%RT


class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end()); // Sort intervals by start time
        int k = 0; // Index for merged intervals
        
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals[k][1] >= intervals[i][0]) { // Overlap detected
                intervals[k][1] = max(intervals[k][1], intervals[i][1]); // Merge
            } else {
                k++; // Move to the next position
                intervals[k] = intervals[i]; // Replace in-place
            }
        }
        
        intervals.resize(k + 1); // Resize to include only merged intervals
        return intervals;
    }
};

/*
//%44.21RT
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ans;
        ranges::sort(intervals);
        for(const vector<int>&interval:intervals){
            if(ans.empty()||ans.back()[1]<interval[0]){
                ans.push_back(interval);
            }
            else
            ans.back()[1] = max(ans.back()[1], interval[1]);
        }
        return ans;
    }
};
*/
