#15



class Solution:
    def canCompleteCircuit(self, gas: list[int], cost: list[int]) -> int:
        
        if sum(gas) < sum(cost): return -1
                
        tank = idx = 0

        for i in range(len(gas)):     
            tank+= gas[i]-cost[i]
            if tank < 0:
                tank, idx = 0, i+1

        return idx 




#13ms


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        summ = 0
        curr = 0
        start = 0

        for i in range(0, len(gas)):
            summ += gas[i] - cost[i]
            curr += gas[i] - cost[i]

            if curr < 0:
                curr = 0
                start = i+1
        
        return start if summ >= 0 else -1





#11ms




class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        '''
        gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        starting at 0: tank = 1
        at 1, tank = 1 - 3 < 0-> fail
        starting at 1: tank = 2
        at 2, tank = 2 - 4 < 0 -> fail
        starting at 3: tank = 4
        at 4, tank = 4-1 ( > 0 -> pass) + 5(gas[4]) = 8
        at 0, tank = 8 - 2 ( > 0 -> pass) + 1(gas[0]) = 7
        Thus, at i, current tank - cost[i] > 0, move to i + 1 and tank = tank + gas[i+1]
        '''
        if sum(gas) < sum(cost):
            return -1
        
        res = 0
        total = 0

        for i in range(len(gas)):
            total +=gas[i]-cost[i]

            if total < 0:
                total = 0
                res = i+1
        return res

