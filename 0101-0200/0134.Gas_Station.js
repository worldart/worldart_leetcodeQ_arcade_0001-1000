//1ms



/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit = function(gas, cost) {
 
        let total_tank = 0, curr_tank = 0, start_index = 0;
        for (let i = 0; i < gas.length; i++) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            if (curr_tank < 0) {
                start_index = i + 1;
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? start_index : -1;
    

};



//0ms




/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit = function(gas, cost) {
    let totalTank = 0
    let currTank = 0
    let start = 0
    for (let i = 0; i < gas.length; i++) {
        let diff = gas[i] - cost[i]
        totalTank = totalTank + diff
        currTank = currTank + diff
        if (currTank < 0) {
            start = i + 1
            currTank = 0
        }
    }
    return totalTank >= 0 ? start : -1 
};
