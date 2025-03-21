//0ms

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();

        int p1=1, p2=1, p3=0;

        if(l1+l2 != l3)
            return false;
        
        Boolean[][] memo = new Boolean[l1+1][l2+1];
        //memo[0][0] = true;
        boolean res = util(0, 0, 0, c1, c2, c3, memo);

        // for(Boolean[] barr: memo) {
        //     for(Boolean b: barr){
        //         System.out.print(b+" ");
        //     }
        //     System.out.println();
        // }
        //return memo[l1][l2];
        return res;
    }

    boolean util(
        int p1,
        int p2,
        int p3,
        char[] c1,
        char[] c2,
        char[] c3,
        Boolean[][] memo
    ) {
        if(p1==c1.length && p2==c2.length) {
            return true;
        }

        if(memo[p1][p2] != null)
            return memo[p1][p2];

        boolean res = false;
        if(p1<c1.length && c1[p1] == c3[p3]) {
            res = util(p1+1, p2, p3+1, c1, c2, c3, memo);
        }
        if(p2<c2.length && c2[p2] == c3[p3]) {
            res = res || util(p1, p2+1, p3+1, c1, c2, c3, memo);
        }

        return memo[p1][p2] = res;
    }
}
