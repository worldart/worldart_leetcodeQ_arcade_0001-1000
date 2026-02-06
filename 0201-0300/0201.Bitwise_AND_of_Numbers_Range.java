//3ms





class Solution { 
    public int rangeBitwiseAnd(int m, int n) { 
        int i = 0; 
        for (; m != n; ++i) { 
            m >>= 1; 
            n >>= 1; 
        } 
        return n << i; 
    } 
}     






//3ms






class Solution {
    public int rangeBitwiseAnd(int left, int right) {
            while(left<right){
            right = right & (right-1);
        }
        return right;
    }
}
