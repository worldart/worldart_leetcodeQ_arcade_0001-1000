//0ms



impl Solution {
    pub fn can_complete_circuit(gas: Vec<i32>, cost: Vec<i32>) -> i32 {
        let mut origin = -1;
        let mut surplus = 0;
        let balance = gas
            .iter()
            .zip(cost.iter())
            .enumerate()
            .fold(0, |balance, (i, (g, c))| {
                let delta = g - c;
                if origin == -1 {
                    if delta >= 0 {
                        origin = i as i32;
                        surplus = delta;
                    }
                } else {
                    surplus += delta;
                    if surplus < 0 {
                        origin = -1;
                        surplus = 0;
                    }
                }
                balance + delta
            });
        if balance >= 0 {
            return origin;
        }
        -1
    }
}




//0ms





impl Solution {
    pub fn can_complete_circuit(gas: Vec<i32>, cost: Vec<i32>) -> i32 {
        
        let mut gas_accumulation = 0; 
        let mut curr_accumulation = 0;
        let mut response = 0;
        
        for i in 0..gas.len(){
            
            let sum = gas[i] - cost[i];

            curr_accumulation += sum;
            gas_accumulation +=sum; 

            if curr_accumulation < 0 {
                response = i+1;
                curr_accumulation = 0;
            } 

        }

        if gas_accumulation < 0{
            -1
        }else{
            response as i32 
        }

            
    }
}
