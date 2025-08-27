//0ms






class Solution {
    public int trailingZeroes(int n) {
    int res = 0;
    while (n > 0) {
        n /= 5;
        res += n;
    }
    return res;
}}







//1ms






class Solution {
    public int trailingZeroes(int n) {
        int twos = 0, fives = 0;

        // Count powers of 2
        for (int i = 2; Math.pow(2, i) <= n; i++) {
            twos += n / (int)Math.pow(2, i);
        }
        twos += n / 2;

        // Count powers of 5
        for (int i = 2; Math.pow(5, i) <= n; i++) {
            fives += n / (int)Math.pow(5, i);
        }
        fives += n / 5;

        return Math.min(twos, fives);
    }
}
