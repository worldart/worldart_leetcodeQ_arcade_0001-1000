//9ms







class Solution {
    public int reverseBits(int n) {
       String s = Integer.toBinaryString(n);
       String s1=String.format("%32s", s).replace(' ', '0');
       StringBuilder rs = new StringBuilder(s1).reverse();
       return (int) Long.parseLong(rs.toString(),2);
        /* Smplw WAY 0 ms 
        int result = 0;
        for(int i=0;i<32;i++){
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;    
        }
        return result;*/

    }
}






//0ms






class Solution {
    public int reverseBits(int n) {
        int ans=0,power=31;
        while(n!=0){
            ans += (n&1)<<power;
            power--;
            n>>=1;
        }
        return ans;
    }   
}
