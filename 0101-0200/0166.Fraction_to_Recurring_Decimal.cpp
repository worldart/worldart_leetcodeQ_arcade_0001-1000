//0ms





class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        string result;

        if ((numerator < 0) ^ (denominator < 0)) result += "-";

        long long n = abs((long long)numerator);
        long long d = abs((long long)denominator);

        result += to_string(n / d);
        long long remainder = n % d;

        if (remainder == 0) return result; 
        result += ".";

        unordered_map<long long, int> seen; 

        while (remainder != 0) {
            if (seen.find(remainder) != seen.end()) {
                result.insert(seen[remainder], "(");
                result += ")";
                break;
            }

            seen[remainder] = result.size();
            remainder *= 10;
            result += to_string(remainder / d);
            remainder %= d;
        }

        return result;
    }
};





//0ms







class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {

        long num=numerator, denom=denominator;

        // Account for sign
        string sign;
        if((num<0 && denom>0) || (num>0 && denom<0)){
            sign="-";
            num = abs(num);
            denom = abs(denom);
        }
        
        // Handle number before decimal point
        string s1;
        long n=num/denom;
        if(n==0){s1+='0';}
        while(n!=0){
            s1+=((n)%10+'0');
            n/=10;
        }
        std::reverse(s1.begin(),s1.end());

        // Handle number after decimal point
        string s2;
        num = num%denom;
        unordered_map<int,int> numSet;
        int ind=0;
        while(num!=0){
            //std::cout<<num<<" "<<s2<<"\n";
            if(numSet.find(num)==numSet.end()){
                numSet[num]=ind++;
                num*=10;
                s2+=(num/denom + '0');
                num = num%denom;
            }
            else{
                s2.insert(s2.begin()+numSet[num],'(');
                s2.insert(s2.end(),')');
                break;
            }
        }
        s1 = sign+s1;
        if(!s2.empty()){
            s1 = s1+'.'+s2;
        }

        return(s1);
    }
};






//3ms






class Solution {
public:
    string fractionToDecimal(int nu, int de) {
       if(nu==0) return "0";
        string res = "";
        if((nu<0)^(de<0)) res+="-";
        long num = abs((long)nu);
        long den = abs((long)de);
        
        res+= to_string(num/den);
        long rem = num%den;
        if(rem==0) return res;
        res+=".";
        unordered_map<long , int>seen;
        string part = "";
        while(rem!=0){
            if(seen.count(rem)){
                part.insert(seen[rem], "(");
                part+=")";
                break;
            }
            seen[rem] = part.size();
            rem*=10;
            part+=to_string(rem/den);
            rem%=den;
        }
        res+=part;
        return res;
    }
};
