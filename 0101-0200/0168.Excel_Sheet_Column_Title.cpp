//0ms






class Solution {
public:
    string convertToTitle(int columnNumber) {
        string res;
       while(columnNumber>0){
        columnNumber--;
             int k=columnNumber%26;
             columnNumber/=26;
             res+=char('A'+k);
       }
       reverse(res.begin(),res.end());
       return res;
    }
};






//0ms






class Solution {
public:
    string convertToTitle(int columnNumber) {
        string res="";
        while(columnNumber>0)
        {
            columnNumber--;
            res=char(columnNumber%26+'A')+res;
            columnNumber/=26;
        }
        return res;
    }
};
