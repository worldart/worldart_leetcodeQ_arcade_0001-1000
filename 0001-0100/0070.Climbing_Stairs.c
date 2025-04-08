//0ms


int climbStairs(int n) {
    int res = 0;
    
    int secondNext = 0;
    int next = 0;
    for (int i = 1; i <= n; i++) {
        if (i == 1) {
            res = 1;
        } else if (i == 2) {
            res = 2;
        } else {
            res = secondNext + next;
        }
        
        next = secondNext;
        secondNext = res;
    }
    
    return res;
}
