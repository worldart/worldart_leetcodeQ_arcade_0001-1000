//0ms





class Solution {
    public boolean isHappy(int n) {
        if(n==1 || n==7) return true;
        else if(n<10) return false;
        else{
            int sum=0;
            while(n>0){
                int temp=n%10;
                sum+= temp*temp;
                n=n/10;
            }
            return isHappy(sum);
        }
    }
}






//0ms






class Solution {
    public boolean isHappy(int n) {
        // int n = num;
        while(n != 1 && n != 4){
            int sum =0;
           while(n !=0){
               int digit = n %10;
               sum += digit * digit;
                n = n/10;
        }
        n = sum;
        }
        if(n == 1){
            return true;
        }else{
            return false;
        }
    }
}
