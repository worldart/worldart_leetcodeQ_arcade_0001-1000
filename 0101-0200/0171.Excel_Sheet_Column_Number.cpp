//0ms





class Solution {
public:
    int titleToNumber(string columnTitle) {
        int n=columnTitle.size();
        int ans=0;

        for(int i=n-1;i>=0;i--){
            ans+=(columnTitle[i]-'A'+1)*pow(26,n-i-1);
        }
        return ans;
    }
};







//0ms






class Solution {
public:
    int titleToNumber(string columnTitle) {
        long long exp = 1;
        long long res{0};
        
        for (auto it = columnTitle.rbegin(); it != columnTitle.rend(); ++it) {
            res += (*it - 'A' + 1) * exp;
            exp *= 26;
        }
        
        return res;
    }
};
