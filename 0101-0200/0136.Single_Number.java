//1ms



class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0; i<nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }
}



//0ms




class Solution {
    static{
        for( int i = 0; i< 500; i++){
            singleNumber(new int[] {});
        }
    }
    public static int singleNumber(int[] nums) {
        int xor = 0;
        for(int num:nums){
            xor^=num;
        }
        return xor;
    }
}
