//8ms



class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        
        int tank = 0, idx = 0;

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                idx = i + 1;
            }
        }

        return idx;
    }
}





//0ms



class Solution {
    static {
        for (int i = 0; i < 500; i++) canCompleteCircuit(new int[]{i, i},new int[]{i, i});
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int curr = 0;
        int tank = 0;
        int total_cost = 0;
        for(int i = 0;i<n;i++){
            int diff = gas[i]-cost[i];
            total_cost+=diff;
            tank+=diff;
            if(tank<0){
                curr = i+1;
                tank = 0;
            }
        }
        
        return total_cost < 0 ? -1 : curr;
    }
}



//1ms




class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = n - 1, end = 0;
        int tank = gas[start] - cost[start];
        while (start > end) {
            if (tank < 0) {
                start--;
                tank += gas[start] - cost[start];
            } else {
                tank += gas[end] - cost[end];
                end++;
            }
        }
        return tank >= 0 ? start : -1;
    }
}
