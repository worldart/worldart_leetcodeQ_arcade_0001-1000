//0ms





class Solution {
public:
    bool isHappy(int n) {
        std::string y = std::to_string(n);
        int m = 0;

        while (m != 4) {
            m = 0;
            for (char x : y) {
                int d = x - '0';
                m += d * d;
            }
            if (m == 1) return true;
            y = std::to_string(m);
        }

        return false;
    }
};






//0ms






class Solution {
public:
    bool isHappy(int n) {
       int rem,sum;
       while(n!=1&&n!=4)
       {
        sum=0;
        while(n!=0){
          rem=n%10;
          sum=sum+rem*rem;
          n/=10;
        }
        n=sum;}
        if(n==1)return 1;
        else return 0; 
    }
};
