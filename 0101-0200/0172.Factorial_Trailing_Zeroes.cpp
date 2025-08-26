//0ms





class Solution {
public:
    int trailingZeroes(int n) {
        int ans = 0;
        int div = 5;

        while(n>=div)
        {
            ans+= (n/div);
            div*=5;
        }

        return ans;
    }
};






//0ms






class Solution {
public:
    int trailingZeroes(int n) {
        int c=0;
        for(int i=5;i<=n;i=i*5){
            c+=n/i;
        }
        return c;
    }
};
