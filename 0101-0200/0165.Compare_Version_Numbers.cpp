//0ms






class Solution {
public:
    int compareVersion(string version1, string version2) {   
        int i = 0, j = 0, n1 = version1.size(), n2 = version2.size(), num1 = 0, num2 = 0; 
        while(i<n1 || j<n2)
        {
            while(i<n1 && version1[i]!='.')
            {
                num1 = num1*10+(version1[i]-'0');
                i++;
            }
            while(j<n2 && version2[j]!='.')
            {
                num2 = num2*10+(version2[j]-'0');
                j++;
            }
            if(num1>num2)
            {
                return 1;
            }
            if(num1 < num2) 
            {
                return -1;
            }
            i++;
            j++;
            num1 = 0;
            num2 = 0;
        }
        return 0; 
    }
};






//1ms







class Solution {
public:
    int compareVersion(string version1, string version2) {
        int i = 0;
        int j = 0;
        int ver = 1;
        bool full1=false;bool full2=false;
        while (i < version1.size() || j < version2.size()) {
            string number1;
             int num1;
             if(i>=version1.size()){
                full1=true;
                num1=0;
             }
            while (i < version1.size() and version1[i] != '.') {
                number1.push_back(version1[i]);
                i++;
            }
           
            if(!full1){
                num1 = stoi(number1);
            }
            

            string number2;
            int num2;
            if (j >= version2.size()) {
                full2=true;
                num2 = 0;
            }
            while (j<version2.size() and version2[j] != '.') {
                number2.push_back(version2[j]);
                j++;
            }
            if(!full2){
                num2=stoi(number2);
            }
            if (num1 > num2) {
                return 1;
            } else if (num2 > num1) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
};
