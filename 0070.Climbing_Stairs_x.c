//0ms

int climbStairs(int n) {
    int secondLast = 0;
    int last = 1;
    for (int i = 1; i <= n; i++) {
        int temp = last;
        last = secondLast + last;
        secondLast = temp;
    }
    return last;
}
