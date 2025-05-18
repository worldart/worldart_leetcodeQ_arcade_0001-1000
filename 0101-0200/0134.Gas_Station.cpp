//0ms




class Solution {
public:
    int canCompleteCircuit(std::vector<int>& gas, std::vector<int>& cost) {
        if (std::accumulate(gas.begin(), gas.end(), 0) < std::accumulate(cost.begin(), cost.end(), 0)) {
            return -1;
        }
        
        int tank = 0, idx = 0;

        for (int i = 0; i < gas.size(); ++i) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                idx = i + 1;
            }
        }

        return idx;
    }
};



//4ms



class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int remain=0;
        int n=gas.size();
        int totalgas=0;
        int totalcost=0;
        int ans=0;
        for(int i=0;i<n;i++){
            totalgas+=gas[i];
            totalcost+=cost[i];
            remain+=(gas[i]-cost[i]);
            if(remain<0){
                remain=0;
                ans=i+1;
            }
        }
        if(totalcost>totalgas) return -1;
        return (ans==n)?-1:ans;
    }
};
