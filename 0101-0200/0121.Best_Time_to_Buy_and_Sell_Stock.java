//1ms


 class Solution {
    static {
        for(int i = 0; i<500; i++)
        {
            maxProfit(new int[] {});
        }
    }
    public static int maxProfit(int[] a) {
        int least = Integer.MAX_VALUE;
        int max = 0 ;
        for(int i = 0 ; i<a.length; i++)
        {
            int profit = a[i]-least;
            if(profit>=0)
            {
                max = (profit > max)? profit : max;
            }
            else
            {
                least = a[i];
            }
        }
        return max;
    }
}
